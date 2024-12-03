package com.example.evaaamo.entities;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;
    @Nonnull
    LocalDate startDate;
    @Nullable
    LocalDate endDate;
    @Nullable
    String title;
    @Nullable
    String description;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Media> mediaUrls;

    public Event(long eventId, @Nonnull LocalDate startDate, @Nullable LocalDate endDate, @Nullable String title, @Nullable String description, List<Media> mediaUrls) {
        this.eventId = eventId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.mediaUrls = mediaUrls;
    }

    public Event(@Nonnull LocalDate startDate, @Nullable LocalDate endDate, @Nullable String title, @Nullable String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public Event() {
    }

    public long getEventId() {
        return eventId;
    }

    @Nonnull
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@Nonnull LocalDate startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable LocalDate endDate) {
        this.endDate = endDate;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public List<Media> getMediaUrls() {
        return mediaUrls;
    }

    public void setMediaUrls(List<Media> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }
}
