package com.example.evaaamo.controllers;

import com.example.evaaamo.entities.ArtWork;
import com.example.evaaamo.repositories.ArtWorkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalleriController {
    private ArtWorkRepository artWorkRepository;

    public GalleriController(ArtWorkRepository artWorkRepository){
        this.artWorkRepository = artWorkRepository;
    }

    @GetMapping("/galleri")
    /*public List<ArtWork> getArtWorks() {
        return artWorkRepository.findAll();
    }
     */
    public String viewGalleri(Model model){
        List<ArtWork> artWorks = artWorkRepository.findAll();

        model.addAttribute("artworks", artWorks);

        return "galleri";
    }
}
