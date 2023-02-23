package com.example.pharmacy.direction.repository;

import com.example.pharmacy.direction.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
