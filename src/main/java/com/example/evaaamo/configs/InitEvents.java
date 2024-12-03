package com.example.evaaamo.configs;

import com.example.evaaamo.entities.Event;
import com.example.evaaamo.entities.Media;
import com.example.evaaamo.repositories.EventRepository;
import com.example.evaaamo.repositories.MediaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class InitEvents implements CommandLineRunner {

    private final MediaRepository mediaRepository;
    private final EventRepository eventRepository;

    public InitEvents(MediaRepository mediaRepository, EventRepository eventRepository) {
        this.mediaRepository = mediaRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Media
        Media pic1 = new Media();
        pic1.setMediaUrl("https://miro.medium.com/v2/resize:fit:1400/1*Yb2W5n4-ZyQZ8ggggHGCZA.png");

        Media vid1 = new Media();
        vid1.setMediaUrl("https://www.youtube.com/embed/EShUeudtaFg?si=5Cg_1H8yUQcEfDlI");

        Media pic2 = new Media();
        pic2.setMediaUrl("https://upload.wikimedia.org/wikipedia/commons/6/69/Louvre_Museum_Wikimedia_Commons.jpg");

        // Save media individually
        mediaRepository.save(pic1);
        mediaRepository.save(vid1);
        mediaRepository.save(pic2);

        // Create Events
        Event event1 = new Event();
        event1.setStartDate(LocalDate.of(2024, 5, 10));
        event1.setEndDate(LocalDate.of(2024, 5, 12));
        event1.setTitle("Kunstudstilling i København");
        event1.setDescription("En smuk udstilling med værker fra forskellige kunstnere, der fremhæver den danske kultur.");
        event1.setMediaUrls(Arrays.asList(pic1, vid1));

        Event event2 = new Event();
        event2.setStartDate(LocalDate.of(2024, 6, 5));
        event2.setEndDate(LocalDate.of(2024, 6, 8));
        event2.setTitle("Skulpturfestival i Aarhus");
        event2.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");
        event2.setMediaUrls(Arrays.asList(pic2));

        // Save events
        eventRepository.save(event1);
        eventRepository.save(event2);

        System.out.println("Initialized events with media successfully!");
    }
}
