package com.example.navire_backend.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Receptionneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int tel;
    @ManyToOne
    @JoinColumn(name = "navire_id")
    private Navire navire;
    @OneToMany(mappedBy = "receptionneur", cascade = CascadeType.ALL)
    private List<CargaisonRec> cargaisonRec = new ArrayList<>();;


}
