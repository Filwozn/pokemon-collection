package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    private LoginService loginService;


    public LogoutController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/logout")
    public String logoutUser(){
        loginService.logout();
        return "redirect:/";
    }
}
