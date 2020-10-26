package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllCardsController extends BaseController {
    private DataBaseCardRepository cardRepository;

    public AllCardsController(DataBaseCardRepository cardRepository, LoginService loginService) {
        super(loginService);
        this.cardRepository = cardRepository;
    }

@GetMapping("/all-cards")
    public String showAllCards(Model model){
        model.addAttribute("cards",cardRepository.findAll());
        return "all-cards";
    }
}
