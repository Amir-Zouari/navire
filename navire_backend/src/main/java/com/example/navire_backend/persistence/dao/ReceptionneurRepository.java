package com.example.navire_backend.persistence.dao;
import com.example.navire_backend.persistence.entities.Receptionneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceptionneurRepository extends JpaRepository<Receptionneur, Integer> {
    @Query(value = "select * from receptionneur where name= :name",nativeQuery = true)
    List<Receptionneur> findAllByPrenom(@Param("name") String name);

    List<Receptionneur> findAllByPrenomAndNom(String prenom,String nom);
}
