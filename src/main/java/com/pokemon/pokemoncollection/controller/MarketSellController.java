package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.auction.AuctionService;
import com.pokemon.pokemoncollection.service.auction.AuctionServiceException;
import com.pokemon.pokemoncollection.service.login.LoginService;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketSellController extends BaseController {
    private TrainerService trainerService;
    private AuctionService auctionService;

    public MarketSellController(TrainerService trainerService, AuctionService auctionService, LoginService loginService) {
        super(loginService);
        this.trainerService = trainerService;
        this.auctionService = auctionService;
    }

    @GetMapping("/sell")
    public String getAuctionSellPage(Model model) {
        Trainer trainer = trainerService.getLoggedTrainer();
        model.addAttribute("cards", trainer.getCards().keySet());
        return "market-sell";
    }

    @GetMapping("/sell/{id}")
    public String getSellingForm(@PathVariable String id, Model model) {
        try {
            int cardsAmount = auctionService.howManySameIdCard(id);

            if (cardsAmount <= 0) {
                return redirectHomePage(model, "Nie odnaleziono karty", MessageType.ERROR);
            }
            model.addAttribute("card", auctionService.findCardById(id));
            model.addAttribute("amount", cardsAmount);
            return "sell-form";
        } catch (AuctionServiceException e) {
            return redirectHomePage(model, e.getMessage(), MessageType.ERROR);
        }
    }

    @PostMapping("/sell/{id}")
    public String sendSellingForm(@PathVariable String id, int amount, int price, Model model) {
        try {
            auctionService.sellCards(id, amount, price);
        } catch (AuctionServiceException e) {
            return redirectHomePage(model, e.getMessage(), MessageType.ERROR);
        }
        return "redirect:/market/sell";
    }
}
