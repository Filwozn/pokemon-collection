package com.pokemon.pokemoncollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    /*@GetMapping("/login")
    public String getLoginForm() {
        System.out.println("Poprawne logowanie");
        return "login-form";
    }*/
    @GetMapping("/login")
    public String getLoginErrorForm(boolean error, Model model) {
        if(error){
            model.addAttribute("error",true);
        }
        return "login-form";
    }
}
