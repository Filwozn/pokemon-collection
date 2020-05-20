package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.login.LoginServiceException;
import com.pokemon.pokemoncollection.service.pack.PackService;
import com.pokemon.pokemoncollection.service.pack.PackServiceException;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import com.pokemon.pokemoncollection.service.trainer.TrainerServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PackController {
    private TrainerService trainerService;
    private PackService packService;

    public PackController(TrainerService trainerService, PackService packService) {
        this.trainerService = trainerService;
        this.packService = packService;
    }

    @GetMapping("/pack")
    public String getPackPage(Model model){
        try {
            Trainer trainer = trainerService.getLoggedTrainer();
            model.addAttribute("trainer", trainer);
        }catch (TrainerServiceException e){
            return "redirect:/trainer";
        }catch (LoginServiceException e){
            return "redirect:/login";
        }
        return "pack-open";
    }

    @PostMapping("/pack")
    public String openPack(Model model){
        try {
            List<Card> pack = packService.openPack();
            model.addAttribute("pack", pack);
        }catch (PackServiceException e){
            return "redirect:/coins";
        }
        return "new-cards";
    }

}
