package com.example.evaaamo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalleriController {
    private ArtWorkRepository artWorkRepository;

    public GalleriController(ArtWorkRepository artWorkRepository){
        this.artWorkRepository = artWorkRepository;
    }

    @GetMapping("/galleri")
    public List<Artwork> getArtWorks() {
        return artWorkRepository.findAll();
    }
}
