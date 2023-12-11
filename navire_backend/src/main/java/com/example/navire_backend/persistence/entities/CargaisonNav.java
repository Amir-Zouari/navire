package com.example.navire_backend.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CargaisonNav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCar;
    private String typeCar;
    private double tonnage;

}
