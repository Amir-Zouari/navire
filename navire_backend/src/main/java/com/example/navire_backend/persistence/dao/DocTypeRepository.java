package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DocTypeRepository extends JpaRepository<DocType, Integer> {
}
