package com.example.evaaamo.configs;

import com.example.evaaamo.entities.Picture;
import com.example.evaaamo.entities.Video;
import com.example.evaaamo.repositories.PictureRepository;
import com.example.evaaamo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class InitPicturesAndVids implements CommandLineRunner {

   private PictureRepository pictureRepository;
   private VideoRepository videoRepository;

public InitPicturesAndVids(PictureRepository pictureRepository, VideoRepository videoRepository) {
    this.pictureRepository =pictureRepository;
    this.videoRepository = videoRepository;
}
    @Override
    public void run(String... args) throws Exception {

        Picture pic1 = new Picture("https://miro.medium.com/v2/resize:fit:1400/1*Yb2W5n4-ZyQZ8ggggHGCZA.png");
        pictureRepository.save(pic1);
        Video vid1 = new Video("https://www.youtube.com/embed/EShUeudtaFg?si=5Cg_1H8yUQcEfDlI");
        videoRepository.save(vid1);
    }
}
