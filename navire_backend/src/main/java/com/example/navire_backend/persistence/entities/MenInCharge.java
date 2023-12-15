package com.example.navire_backend.persistence.entities;
import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.DTO.MenInChargeDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenInCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int tel;
    @ManyToOne
    @JoinColumn(name = "armateur_id")
    @JsonBackReference
    private Armateur armateur;
    public MenInChargeDTO toDTO() {
        boolean boolArmateur= armateur!=null;
        return new MenInChargeDTO(id, nom,prenom,tel, boolArmateur ? armateur.getId() : 0,boolArmateur?armateur.getNom():"");
    }

}


