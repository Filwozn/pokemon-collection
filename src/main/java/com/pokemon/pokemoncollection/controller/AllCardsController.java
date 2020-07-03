package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllCardsController {
    private DataBaseCardRepository cardRepository;

    public AllCardsController(DataBaseCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

@GetMapping("/all-cards")
    public String showAllCards(Model model){
        model.addAttribute("cards",cardRepository.findAll());
        return "all-cards";
    }
}
