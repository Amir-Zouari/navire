package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> { }
