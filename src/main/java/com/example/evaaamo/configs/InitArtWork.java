package com.example.evaaamo.configs;

import com.example.evaaamo.entities.ArtWork;
import com.example.evaaamo.entities.ArtWorkTag;
import com.example.evaaamo.entities.Media;
import com.example.evaaamo.entities.TagType;
import com.example.evaaamo.repositories.ArtWorkRepository;
import com.example.evaaamo.repositories.ArtWorkTagRepository;
import com.example.evaaamo.repositories.MediaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class InitArtWork implements CommandLineRunner {

    private ArtWorkRepository artWorkRepository;
    private MediaRepository mediaRepository;
    private ArtWorkTagRepository artWorkTagRepository;

    public InitArtWork(ArtWorkRepository artWorkRepository,
                       MediaRepository mediaRepository,
                       ArtWorkTagRepository artWorkTagRepository) {
        this.artWorkRepository = artWorkRepository;
        this.mediaRepository = mediaRepository;
        this.artWorkTagRepository = artWorkTagRepository;
    }


    @Override
    public void run(String... args) throws Exception {
       //oprettet og gemt mediet.
        Media media1 = new Media("https://miro.medium.com/v2/resize:fit:1400/1*Yb2W5n4-ZyQZ8ggggHGCZA.png");
        mediaRepository.save(media1);

        ArtWork artWork1 = new ArtWork();
        artWork1.setTitle("Unavngivet");
        artWork1.setDescription("Bla blasåå fint, bør i skov. meget mystisk og noget " +
                "med røg og støv og vilde ting og giver dig en mærkelig følelse, så nu " +
                "vil du rigtigt gerne købe den jauhuu");
        artWork1.setPrice(1000);
        artWork1.setSold(false);
        artWork1.setType(true);
        artWork1.setMedia(media1);

        //opret tags og gem dem til artworket
        ArtWorkTag tag1 = new ArtWorkTag(TagType.SIZE, "100x100", artWork1);
        ArtWorkTag tag2 = new ArtWorkTag(TagType.THEME, "Natur", artWork1);
        ArtWorkTag tag3 = new ArtWorkTag(TagType.COLOR, "Grøn", artWork1);

        List<ArtWorkTag> tags = List.of(tag1, tag2, tag3);
        artWork1.setTags(tags);

        //Tror denne bliver nødt til at være først,
        // da den ikke kan gemme tag uden et tilhørende artwork
        artWorkRepository.save(artWork1);

        artWorkTagRepository.saveAll(tags);

        //gem Artworket
        //artWorkRepository.save(artWork1);


    }


}
