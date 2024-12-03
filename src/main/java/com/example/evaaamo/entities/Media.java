package com.example.evaaamo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mediaId;
    private String mediaUrl;

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
}
