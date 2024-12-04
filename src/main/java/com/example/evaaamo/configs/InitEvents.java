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
        Media pic1 = new Media("https://drive.google.com/file/d/1t9kR9zP8hg65fSrWt7akc4qL3LvChKx8");
        Media pic2 = new Media("https://drive.google.com/file/d/13ESaXYb7MCcUDQpz3k5TUc4rL1TW2sUx");
        Media pic3 = new Media("https://drive.google.com/file/d/13K92S6VZnW24vfL62EgPsvEAUH40cmoi");
        Media pic4 = new Media("https://drive.google.com/file/d/1M6rhHkpaIOKP-josJMEGYdZVPKIyebXq");
        Media pic5 = new Media("https://drive.google.com/file/d/1pa8lOX3l9IGoocaTmjas_4Vzekel9tFX");
        Media pic6 = new Media("https://drive.google.com/file/d/1Owv5KOuksV0NjwmTDCvQlCXgltJv27rs");

        Media vid1 = new Media("https://www.youtube.com/embed/EShUeudtaFg?si=5Cg_1H8yUQcEfDlI");

        // Create Events
        Event event1 = new Event();
        event1.setStartDate(LocalDate.of(2024, 5, 10));
        event1.setTitle("Kunstudstilling i København");
        event1.setDescription("En smuk udstilling med værker fra forskellige kunstnere, der fremhæver den danske kultur.");

        Event event2 = new Event();
        event2.setStartDate(LocalDate.of(2024, 6, 5));
        event2.setEndDate(LocalDate.of(2024, 6, 8));
        event2.setTitle("Skulpturfestival i Aarhus");
        event2.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");

        Event event3 = new Event();
        event3.setStartDate(LocalDate.of(2021, 3, 4));
        event3.setTitle("Skulpturfestival i Aarhus");
        event3.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");

        Event event4 = new Event();
        event4.setStartDate(LocalDate.of(2020, 1, 4));
        event4.setEndDate(LocalDate.of(2020, 1, 8));
        event4.setTitle("Skulpturfestival i Aarhus");
        event4.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");

        Event event5 = new Event();
        event5.setStartDate(LocalDate.of(2025, 6, 5));
        event5.setEndDate(LocalDate.of(2025, 6, 8));
        event5.setTitle("Skulpturfestival i Aarhus");
        event5.setDescription("En festival dedikeret til skulpturer fra hele verden, der finder sted i hjertet af Aarhus.");

        // Associate Media with Events
        pic1.setEvent(event1);
        pic2.setEvent(event1);
        pic3.setEvent(event2);
        pic4.setEvent(event2);
        pic5.setEvent(event2);
        pic6.setEvent(event4);

        vid1.setEvent(event2);

        // Save Events (CascadeType.ALL will handle saving Media)
        event1.setMediaUrls(Arrays.asList(pic1, pic2));
        event2.setMediaUrls(Arrays.asList(pic3, pic4, pic5, vid1));
        event4.setMediaUrls(Arrays.asList(pic6));

        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
        eventRepository.save(event4);
        eventRepository.save(event5);

        System.out.println("Initialized events with media successfully!");
    }

}
