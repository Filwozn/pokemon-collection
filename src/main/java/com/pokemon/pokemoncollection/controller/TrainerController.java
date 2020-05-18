package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.service.LoginService;
import com.pokemon.pokemoncollection.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerController {
    private LoginService loginService;
    private TrainerService trainerService;

    public TrainerController(LoginService loginService, TrainerService trainerService) {
        this.loginService = loginService;
        this.trainerService = trainerService;
    }

    @GetMapping("/trainer")
    public String getTrainerForm(){
        if(loginService.isLogged()){
            return "trainer-form";
        }
            return "login-form";
    }
    @PostMapping("/trainer")
    public String addTrainer(@RequestParam String name,
                             @RequestParam String type){
        TrainerDTO trainerDTO = new TrainerDTO(name, type);
        trainerService.addTrainer(trainerDTO);
        return "trainer-success";
    }


}
