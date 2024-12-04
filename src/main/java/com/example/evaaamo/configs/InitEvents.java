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
        Media pic1 = new Media("https://miro.medium.com/v2/resize:fit:1400/1*Yb2W5n4-ZyQZ8ggggHGCZA.png");
        Media vid1 = new Media("https://www.youtube.com/embed/EShUeudtaFg?si=5Cg_1H8yUQcEfDlI");
        Media pic2 = new Media("https://upload.wikimedia.org/wikipedia/commons/6/69/Louvre_Museum_Wikimedia_Commons.jpg");

        // Create Events
        Event event1 = new Event();
        event1.setStartDate(LocalDate.of(2024, 5, 10));
        event1.setEndDate(LocalDate.of(2024, 5, 12));
        event1.setTitle("Kunstudstilling i København");
        event1.setDescription("En smuk udstilling med værker fra forskellige kunstnere, der fremhæver den danske kultur.");

        Event event2 = new Event();
        event2.setStartDate(LocalDate.of(2024, 6, 5));
        event2.setEndDate(LocalDate.of(2024, 6, 8));
        event2.setTitle("Skulpturfestival i Aarhus");
        event2.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");

        // Associate Media with Events
        pic1.setEvent(event1);
        vid1.setEvent(event1);
        pic2.setEvent(event2);

        // Save Events (CascadeType.ALL will handle saving Media)
        event1.setMediaUrls(Arrays.asList(pic1, vid1));
        event2.setMediaUrls(Arrays.asList(pic2));
        eventRepository.save(event1);
        eventRepository.save(event2);

        System.out.println("Initialized events with media successfully!");
    }

}
