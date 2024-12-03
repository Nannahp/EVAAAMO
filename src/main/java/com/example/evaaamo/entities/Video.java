package com.example.evaaamo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoID;
    private String videoUrl;

    public Video(int videoID, String videoUrl) {
        this.videoID = videoID;
        this.videoUrl = videoUrl;
    }

    public Video(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Video() {
    }

    public int getVideoID() {
        return videoID;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
