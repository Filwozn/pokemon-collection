package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public abstract class BaseController {
    private LoginService loginService;
    public BaseController(LoginService loginService) {
        this.loginService = loginService;
    }

    public String redirectHomePage(Model model, String message, MessageType messageType ){
        model.addAttribute(messageType.getId(),message);

        if(loginService.isLogged()){
            String mail = loginService.getLoggerUserMail();
            model.addAttribute("email", mail);
        } else {
            model.addAttribute("email", "Niezalogowany");
        }
        return "index";
    }
}

enum MessageType {
    ERROR("errorMessage"), SUCCESS("successMessage");
    private String id;

    MessageType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
