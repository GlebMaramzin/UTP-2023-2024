package com.example.authproj.repositories;

import com.example.authproj.models.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupaRepository extends JpaRepository<Grupa, String> {

    List<Grupa> findByTitle(String title);
}
