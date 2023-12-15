package com.example.navire_backend.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenInChargeDTO {
    private int id;
    private String nom;
    private String prenom;
    private int tel;
    private int armateurId;
    private String armateurNom;
}
