package com.example.evaaamo.entities;

import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mediaId;
    private String mediaUrl;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;  // The event this media belongs to


    public Media(int mediaId, String mediaUrl) {
        this.mediaId = mediaId;
        this.mediaUrl = mediaUrl;
    }

    public Media(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
    public Media() {

    }

    public int getMediaId() {
        return mediaId;
    }


    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String pictureUrl) {
        this.mediaUrl = pictureUrl;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
