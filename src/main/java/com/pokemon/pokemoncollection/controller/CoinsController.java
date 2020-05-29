package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.coins.CoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoinsController {
    private CoinService coinService;

    public CoinsController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/coin-shop")
    public String getCoinsPage() {
        return "coin-shop";
    }

    @PostMapping ("/coin-shop")
    public String addCoins(int coinsAmount) {
        coinService.addCoins(coinsAmount);
        return "redirect:pack";
    }
}
