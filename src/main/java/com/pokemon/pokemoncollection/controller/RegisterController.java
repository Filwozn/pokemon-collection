package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.service.RegisterService;
import com.pokemon.pokemoncollection.service.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String getRegisterForm(){
        return "register-form";
    }
    @PostMapping("/register")
    public String addNewUser(@RequestParam String email,
                             @RequestParam String pass){
        System.out.println("Mail: " + email);
        System.out.println("Password: " + pass);
        UserDTO user = new UserDTO(email, pass);
        try {
            registerService.addNewUser(user);
        }catch (RegisterServiceException e) {
            System.out.println(e.getMessage());
        }
        return "register-success";
    }
}
