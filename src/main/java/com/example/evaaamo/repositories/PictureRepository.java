package com.example.evaaamo.repositories;

import com.example.evaaamo.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
