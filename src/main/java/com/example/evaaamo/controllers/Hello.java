package com.example.evaaamo.controllers;

import com.example.evaaamo.entities.Media;
import com.example.evaaamo.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Hello {
    @Autowired
    MediaRepository mediaRepository;

    @GetMapping("/")
    public String index() {
        return "index";
}

    @GetMapping("/hello")
        public String Hello() {
        return "hello";
        }

    @GetMapping("/testing")
    public String testing(Model model) {
        Media pic = mediaRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Picture not found"));
        Media vid = mediaRepository.findById(2).orElseThrow(() -> new IllegalArgumentException("Video not found"));
        model.addAttribute("picture", pic);
        model.addAttribute("video", vid);
        return "testing";
    }
}
