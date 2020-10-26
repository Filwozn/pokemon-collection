package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.service.login.LoginService;
import com.pokemon.pokemoncollection.service.register.RegisterService;
import com.pokemon.pokemoncollection.service.register.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController extends BaseController{
    private RegisterService registerService;

    public RegisterController(RegisterService registerService, LoginService loginService) {
        super(loginService);
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "register-form";
    }

    @PostMapping("/register")
    public String addNewUser(@RequestParam String email,
                             @RequestParam String pass, Model model) {
        UserDTO user = new UserDTO(email, pass);
        try {
            registerService.addNewUser(user);
        } catch (RegisterServiceException e) {
            model.addAttribute("error", e.getMessage());
            return "register-failed";
        }
        return "register-success";
    }
}
