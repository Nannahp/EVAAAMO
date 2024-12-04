package com.example.evaaamo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeController {

    @GetMapping("/om-mig")
    public String aboutMe() {
        return "about-me";
    }
}
