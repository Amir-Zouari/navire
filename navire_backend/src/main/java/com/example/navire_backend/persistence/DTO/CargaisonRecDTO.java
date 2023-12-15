package com.example.navire_backend.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargaisonRecDTO {
    private int id;
    private String type;
    private double tonnage;
    private int receptionneurId;
    private String receptionneurPrenomNom;
}
