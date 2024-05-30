package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Televisor;

@Repository
public interface TelevisorRepository extends JpaRepository<Televisor, Long> {
    
}