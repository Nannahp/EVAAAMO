package com.example.evaaamo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    //For testing
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //For testing
    @GetMapping("/admin/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the secured home page!");
        return "home";
    }

}
