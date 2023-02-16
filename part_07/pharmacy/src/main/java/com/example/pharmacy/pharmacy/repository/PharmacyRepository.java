package com.example.pharmacy.pharmacy.repository;

import com.example.pharmacy.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
