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
    @Transient
    List<String> pictureUrls;
    @Transient
    List<String> videoUrls;

}
