package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Ouvrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrierRepository extends JpaRepository<Ouvrier, Integer> { }
