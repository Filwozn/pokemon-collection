package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.auction.AuctionService;
import com.pokemon.pokemoncollection.service.auction.AuctionServiceException;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("cards", trainer.getCards().keySet());
        return "auction-sell";
    }

    @GetMapping("/market/sell/{id}")
    public String getSellingForm(@PathVariable String id, Model model){
        int cardsAmount = auctionService.howManySameIdCard(id);
        if(cardsAmount <= 0){
            model.addAttribute("error", "Nie odnaleziono karty");
            return "sell-failed";
        }
        model.addAttribute("card", auctionService.findCardById(id));
        model.addAttribute("amount", cardsAmount);
        return "sell-form";
    }

    @PostMapping("/market/sell/{id}")
    public String sendSellingForm (@PathVariable String id, int amount, int price, Model model){
        try {
            auctionService.sellCards(id, amount, price);
        }catch (AuctionServiceException e){
            model.addAttribute("error", e.getMessage());
         return "sell-failed";
        }
      return "/";
    }
}
