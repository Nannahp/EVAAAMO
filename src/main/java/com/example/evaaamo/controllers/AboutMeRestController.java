package com.example.evaaamo.controllers;

import com.example.evaaamo.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class AboutMeRestController {
    @Autowired
    JsonService jsonService;
@GetMapping("/api/about")
    public Map<String, String> getAbout() {
    return jsonService.readJsonFile("static/assets/about.json");
}

}
