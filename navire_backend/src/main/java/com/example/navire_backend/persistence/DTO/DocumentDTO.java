package com.example.navire_backend.persistence.DTO;

import com.example.navire_backend.persistence.entities.CargaisonRec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
    private int id;
    private String type;
    private int navireId;
    private String navireNom;
}