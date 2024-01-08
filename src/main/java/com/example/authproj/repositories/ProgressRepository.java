package com.example.authproj.repositories;

import com.example.authproj.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
