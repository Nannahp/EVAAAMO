package com.example.evaaamo.entities;

import jakarta.persistence.*;

@Entity
public class ArtWorkTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    @Enumerated(EnumType.STRING)
    private TagType tagType;

    private String value;

    @ManyToOne
    @JoinColumn(name = "artworkidfk", nullable = false)
    private ArtWork artWork;

    public ArtWorkTag(TagType tagType, String value, ArtWork artWork) {
        this.tagType = tagType;
        this.value = value;
        this.artWork = artWork;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArtWork getArtWork() {
        return artWork;
    }

    public void setArtWork(ArtWork artWork) {
        this.artWork = artWork;
    }
}
