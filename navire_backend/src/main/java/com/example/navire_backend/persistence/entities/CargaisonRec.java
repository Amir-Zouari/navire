package com.example.navire_backend.persistence.entities;

import com.example.navire_backend.persistence.DTO.CargaisonRecDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CargaisonRec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private double tonnage;
    @ManyToOne
    @JoinColumn(name = "receptionnaire_id")
    @JsonBackReference
    private Receptionneur receptionneur;

    public CargaisonRecDTO toDTO() {
        boolean boolRec= receptionneur!=null;
        return new CargaisonRecDTO(id, type, tonnage,boolRec ? receptionneur.getId(): 0, boolRec ? receptionneur.getPrenom()+" "+receptionneur.getNom() : null);
    }

}

