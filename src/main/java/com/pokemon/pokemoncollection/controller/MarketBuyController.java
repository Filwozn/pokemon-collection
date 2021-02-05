package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.AuctionRequest;
import com.pokemon.pokemoncollection.service.auction.AuctionService;
import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market/buy")
public class MarketBuyController extends BaseController {
    private AuctionService auctionService;

    public MarketBuyController(LoginService loginService, AuctionService auctionService) {
        super(loginService);
        this.auctionService = auctionService;
    }

    @GetMapping
    public String getBuyCardPage(Model model){
        model.addAttribute("data",auctionService.buildMarketBuyPageData());
return "market-buy";
    }
    @PostMapping("/{auctionId}")
    public String buyCard(int buyAmount, @PathVariable int auctionId){
        System.out.println(buyAmount);
        System.out.println(auctionId);
        AuctionRequest auctionRequest = new AuctionRequest(auctionId, buyAmount);
        return "redirect:/market/buy";
    }
    //toDo Wysłać dane do serwisu i napisać dane kupowania.
}


