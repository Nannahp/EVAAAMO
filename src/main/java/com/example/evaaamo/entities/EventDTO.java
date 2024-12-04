package com.example.evaaamo.entities;

import java.time.LocalDate;

public class EventDTO {
    private int eventId;
    private String title;
    private LocalDate startDate;

    public EventDTO(int eventId, String title, LocalDate startDate) {
        this.eventId = eventId;
        this.title = title;
        this.startDate = startDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

