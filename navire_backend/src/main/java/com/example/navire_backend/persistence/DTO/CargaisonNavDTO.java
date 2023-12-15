package com.example.navire_backend.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargaisonNavDTO {
    private int id;
    private String type;
    private double tonnage;
    private int navId;
    private String navNom;
}
