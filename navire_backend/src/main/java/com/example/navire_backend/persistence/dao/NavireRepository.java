package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NavireRepository extends JpaRepository<Navire, Integer> {
}
