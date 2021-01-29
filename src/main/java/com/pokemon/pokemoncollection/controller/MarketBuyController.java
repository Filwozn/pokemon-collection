package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.auction.AuctionService;
import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}


