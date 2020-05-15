package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loginUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        validateEmail(email);
        validatePassword(password);
    }
    public void validateEmail(String email){
        if (email.isBlank()){
            throw new LoginServiceException("Należy podać email.");
        }
        String regex = "^(.+)@(.+)$";
        if(!email.matches(regex)){
            throw new LoginServiceException("Niepoprawny email.");
        }
        if(userRepository.findByEmail(email) == null){
            throw new LoginServiceException("Nie istnieje użytkownik o takim e-mailu.");
        }
    }
    public void validatePassword(String password) {
        if (password.isBlank()) {
            throw new LoginServiceException("Należy podać hasło.");
        }
        if (password.length()<5) {
            throw new LoginServiceException("Za krótkie hasło.");

        }
    }
}
