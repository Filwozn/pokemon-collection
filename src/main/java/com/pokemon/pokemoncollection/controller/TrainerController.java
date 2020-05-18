package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {
    private LoginService loginService;

    public TrainerController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/trainer")
    public String getTrainerForm(){
        return "trainer-form";
    }


}
