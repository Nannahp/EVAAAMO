package com.example.evaaamo.controllers;

import com.example.evaaamo.entities.ArtWork;
import com.example.evaaamo.repositories.GalleriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalleriController {
    private GalleriRepository galleriRepository;

    public GalleriController(GalleriRepository galleriRepository){
        this.galleriRepository = galleriRepository;
    }

    @GetMapping("/galleri")
    public List<ArtWork> getArtWorks() {
        return galleriRepository.findAll();
    }
}
