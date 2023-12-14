package com.example.navire_backend.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private int id;
    private String typeCar;
    private double tonnage;
    @ManyToOne
    @JoinColumn(name = "navire_id")
    @JsonBackReference
    private Navire navire;

}
