package com.pokemon.pokemoncollection.service.register;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.model.User;
import com.pokemon.pokemoncollection.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RegisterService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
@PostConstruct
    private void addTestUser(){
        User user = new User("test@test.pl", passwordEncoder.encode("testy"));
        userRepository.save(user);
    }

    public void addNewUser(UserDTO userDTO){
        String email = userDTO.getEmail();
        String password = passwordEncoder.encode(userDTO.getPassword());
        validateEmail(email);
        validateEmailUnique(email);
        validatePassword(password);
        User user = new User(email, password);
        userRepository.save(user);
    }

    private void validateEmailUnique(String email) {
        if(userRepository.findByEmail(email) != null){
            throw new RegisterServiceException("Taki email już istnieje w bazie danych.");
        }
    }

    public void validateEmail(String email){
        if (email.isBlank()){
            throw new RegisterServiceException("Należy podać email.");
        }
        String regex = "^(.+)@(.+)$";
        if(!email.matches(regex)){
            throw new RegisterServiceException("Niepoprawny email.");

        }
    }
    public void validatePassword(String password) {
        if (password.isBlank()) {
            throw new RegisterServiceException("Należy podać hasło.");
        }
        if (password.length()<5) {
            throw new RegisterServiceException("Za krótkie hasło.");

        }
    }
}
