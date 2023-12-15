package com.example.navire_backend.persistence.DTO;

import com.example.navire_backend.persistence.entities.MenInCharge;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArmateurDTO {
    private int id;
    private String nom;
    private String manager;
    private String operationDep;
    private String email;
    private int tel;
    private String fax;
    private List<Integer> listNavireId;
    private List<MenInCharge> listMenInCharge;

}
