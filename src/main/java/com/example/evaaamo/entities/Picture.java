package com.example.evaaamo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pictureId;
    private String pictureUrl;

    public Picture(int pictureId, String pictureUrl) {
        this.pictureId = pictureId;
        this.pictureUrl = pictureUrl;
    }

    public Picture( String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public  Picture() {

    }

    public int getPictureId() {
        return pictureId;
    }


    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
