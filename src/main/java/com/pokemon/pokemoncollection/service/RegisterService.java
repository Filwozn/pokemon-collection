package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.model.User;
import com.pokemon.pokemoncollection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO){
        String mail = userDTO.getEmail();
        String password = userDTO.getPassword();
        validateEmail(mail);
        validateEmailUnique(mail);
        validatePassword(password);
        User user = new User(mail, password);
        userRepository.save(user);
    }

    private void validateEmailUnique(String mail) {
        if(userRepository.findByEmail(mail) != null){
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
