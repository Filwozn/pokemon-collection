package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.service.login.LoginService;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import com.pokemon.pokemoncollection.service.trainer.TrainerServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerController extends BaseController{
    private LoginService loginService;
    private TrainerService trainerService;

    public TrainerController(LoginService loginService, TrainerService trainerService) {
        super(loginService);
        this.loginService = loginService;
        this.trainerService = trainerService;
    }

    @GetMapping("/trainer")
    public String getTrainerForm(Model model){
        try {
            trainerService.validateUserHasNoTrainer();
        }catch (TrainerServiceException e) {
            model.addAttribute("error", e.getMessage());
            return "trainer-failed";
        }
        return "trainer-form";
    }
    @PostMapping("/trainer")
    public String addTrainer(@RequestParam String name,
                             @RequestParam String type,
                             Model model){
        TrainerDTO trainerDTO = new TrainerDTO(name, type);
        try{
            trainerService.addTrainer(trainerDTO);
        } catch (TrainerServiceException e){
            model.addAttribute("error", e.getMessage());
            return "trainer-failed";
        }
        return "redirect:/statistics";
    }


}
