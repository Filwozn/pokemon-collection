package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

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
