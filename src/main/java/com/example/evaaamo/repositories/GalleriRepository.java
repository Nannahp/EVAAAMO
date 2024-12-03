package com.example.evaaamo.repositories;

import com.example.evaaamo.entities.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleriRepository extends JpaRepository<ArtWork, Integer> {

}
