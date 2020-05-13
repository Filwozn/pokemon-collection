package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public void addNewUser(UserDTO userDTO){
        System.out.println("Zabieramy się za zapisywanie użytkownika");

    }
}
