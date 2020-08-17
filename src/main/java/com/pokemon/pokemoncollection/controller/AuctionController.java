package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.auction.AuctionService;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AuctionController {
    private TrainerService trainerService;
    private AuctionService auctionService;

    public AuctionController(TrainerService trainerService, AuctionService auctionService) {
        this.trainerService = trainerService;
        this.auctionService = auctionService;
    }

    @GetMapping("/market")
    public String getAuctionSellPage(Model model){
        Trainer trainer = trainerService.getLoggedTrainer();
        model.addAttribute("cards", trainer.getCards());
        return "auction-sell";
    }

    @GetMapping("/market/sell/{id}")
    public String getSellingForm(@PathVariable String id, Model model){
        List<Card> cardsList = auctionService.findOwnedCardsById(id);
        System.out.println(cardsList);
        if(cardsList.isEmpty()){
            return "sell-failed";
        }
        model.addAttribute("card", cardsList.get(0));
        model.addAttribute("amount", cardsList.size());
        return "sell-form";
    }



}
