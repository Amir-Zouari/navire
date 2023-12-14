package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
