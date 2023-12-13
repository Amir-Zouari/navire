package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Navire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NavireRepository extends JpaRepository<Navire, Integer> {

    @Query(value = "select * from navire where name= :name",nativeQuery = true)
    List<Navire> findAllByNom(@Param("name") String name);
}
