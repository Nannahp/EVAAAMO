package com.example.evaaamo.controllers;

import com.example.evaaamo.entities.Picture;
import com.example.evaaamo.entities.Video;
import com.example.evaaamo.repositories.PictureRepository;
import com.example.evaaamo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    VideoRepository videoRepository;
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
        Picture picture = pictureRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Picture not found"));
        Video video = videoRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Video not found"));
        model.addAttribute("picture", picture);
        model.addAttribute("video", video);
        return "testing";
    }
}
