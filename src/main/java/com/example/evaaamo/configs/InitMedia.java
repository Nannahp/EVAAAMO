package com.example.evaaamo.configs;

import com.example.evaaamo.entities.Media;
import com.example.evaaamo.repositories.MediaRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitMedia implements CommandLineRunner {

    private MediaRepository mediaRepository;
    public InitMedia(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Media pic1 = new Media("https://miro.medium.com/v2/resize:fit:1400/1*Yb2W5n4-ZyQZ8ggggHGCZA.png");
        Media vid1 = new Media("https://www.youtube.com/embed/EShUeudtaFg?si=5Cg_1H8yUQcEfDlI");
        mediaRepository.save(pic1);
        mediaRepository.save(vid1);
    }
}
