package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.login.LoginService;
import com.pokemon.pokemoncollection.service.login.LoginServiceException;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import com.pokemon.pokemoncollection.service.trainer.TrainerServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YourCardsController extends BaseController{
    private TrainerService trainerService;

    public YourCardsController(TrainerService trainerService, LoginService loginService) {
        super(loginService);
        this.trainerService = trainerService;
    }
    @GetMapping("/your-cards")
    public String getYourCardsPage(Model model){
        try {
            Trainer trainer = trainerService.getLoggedTrainer();
            model.addAttribute("cards", trainer.getCards());
        }catch (TrainerServiceException e){
            return "redirect:/trainer";
        }
        return "your-cards";
    }

}
