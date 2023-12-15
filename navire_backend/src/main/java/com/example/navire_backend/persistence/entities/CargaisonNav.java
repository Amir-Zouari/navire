package com.example.navire_backend.persistence.entities;

import com.example.navire_backend.persistence.DTO.CargaisonNavDTO;
import com.example.navire_backend.persistence.DTO.DocumentDTO;
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
    private String type;
    private double tonnage;
    @ManyToOne
    @JoinColumn(name = "navire_id")
    @JsonBackReference
    private Navire navire;
    public CargaisonNavDTO toDTO() {
        boolean boolNavire= navire!=null;
        return new CargaisonNavDTO(id, type,tonnage,boolNavire ? navire.getId() : 0,boolNavire?navire.getNom():"");
    }

}
