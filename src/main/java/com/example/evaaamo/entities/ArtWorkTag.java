package com.example.evaaamo.entities;

import jakarta.persistence.*;

@Entity
public class ArtWorkTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    @Enumerated(EnumType.STRING)
    private TagType tagType;

    private String tagValue;

    @ManyToOne
    @JoinColumn(name = "artworkidfk", nullable = false)
    private ArtWork artWork;

    public ArtWorkTag(TagType tagType, String tagValue, ArtWork artWork) {
        this.tagType = tagType;
        this.tagValue = tagValue;
        this.artWork = artWork;
    }

    public ArtWorkTag(){

    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public ArtWork getArtWork() {
        return artWork;
    }

    public void setArtWork(ArtWork artWork) {
        this.artWork = artWork;
    }
}
