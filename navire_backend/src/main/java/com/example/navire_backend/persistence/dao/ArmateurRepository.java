package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Armateur;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArmateurRepository extends JpaRepository<Armateur, Integer> {
}
