package com.example.evaaamo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/hello")
        public String Hello() {
        return "hello";
        }
}
