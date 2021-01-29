package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{
    public HomeController(LoginService loginService) {
        super(loginService);
    }
    @GetMapping
    public String getHomePage(Model model){
       return redirectHomePage(model,"Witaj na stronie głównej",MessageType.SUCCESS);
    }
}
