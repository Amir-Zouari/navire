package com.example.navire_backend.persistence.DTO;

import com.example.navire_backend.persistence.entities.CargaisonRec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionneurDTO {
    private int id;
    private String nom;
    private String prenom;
    private int tel;
    private int navireId;
    private String navireNom;
    private List<CargaisonRec> listCargaisonRec = new ArrayList<>();
}
