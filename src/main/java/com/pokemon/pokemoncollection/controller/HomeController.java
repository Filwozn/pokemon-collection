package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private LoginService loginService;
    public HomeController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getHomePage(Model model){
        if(loginService.isLogged()){
            String mail = loginService.getLoggerUserMail();
            model.addAttribute("email", mail);
        } else {
            model.addAttribute("email", "Niezalogowany");
        }
        return "index";
    }
}
