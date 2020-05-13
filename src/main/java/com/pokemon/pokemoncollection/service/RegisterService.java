package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public void addNewUser(UserDTO userDTO){
        validateEmail(userDTO.getEmail());
    }
    public void validateEmail(String email){
        String regex = "^(.+)@(.+)$";
        if(!email.matches(regex)){
            throw new RegisterServiceException("Niepoprawny email.");

        }
    }
}
