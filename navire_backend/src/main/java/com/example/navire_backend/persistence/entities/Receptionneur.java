package com.example.navire_backend.persistence.entities;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.DTO.ReceptionneurDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Navire navire;
    @OneToMany(mappedBy = "receptionneur", cascade = CascadeType.ALL)
    private List<CargaisonRec> listCargaisonRec = new ArrayList<>();

    public ReceptionneurDTO toDTO() {
        boolean boolNavire= navire!=null;
        return new ReceptionneurDTO(id, nom, prenom, tel, boolNavire ? navire.getId() : 0,boolNavire?navire.getNom():"",listCargaisonRec);
    }


}
