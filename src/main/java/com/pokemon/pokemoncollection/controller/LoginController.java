package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.service.LoginService;
import com.pokemon.pokemoncollection.service.LoginServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private LoginService loginService;

    //@Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLoginForm(){
        return "login-form";
    }

    @PostMapping("/login")
    public String logUser(@RequestParam String email,
                          @RequestParam String pass, Model model){
        UserDTO user = new UserDTO(email, pass);
        try {
            loginService.loginUser(user);
        } catch (LoginServiceException e){
            model.addAttribute("error", e.getMessage());
            return "login-failed";
        }
        return "login-success";
    }
}
