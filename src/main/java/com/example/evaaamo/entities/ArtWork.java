package com.example.evaaamo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ArtWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artWorkId;

    private String title;
    private String description;
    private double price;
    private boolean isSold;
    private LocalDateTime dateCreated;
    private boolean type; //maleri eller ej

    @OneToOne
    @JoinColumn(name = "mediaidfk", referencedColumnName = "mediaId", nullable = false)
    private Media media;

    @OneToMany(mappedBy = "artWork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtWorkTag> tags = new ArrayList<>();


    public ArtWork(long artWorkId, String title,
                   String description, double price,
                   boolean isSold, LocalDateTime dateCreated,
                   boolean type, Media media) {
        this.artWorkId = artWorkId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.isSold = isSold;
        this.dateCreated = dateCreated;
        this.type = type;

        this.media = media;

    }

    public ArtWork() {

    }

    public long getArtWorkId() {
        return artWorkId;
    }

    public void setArtWorkId(long artWorkId) {
        this.artWorkId = artWorkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }


    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public List<ArtWorkTag> getTags() {
        return tags;
    }

    public void setTags(List<ArtWorkTag> tags) {
        this.tags = tags;
    }
}
