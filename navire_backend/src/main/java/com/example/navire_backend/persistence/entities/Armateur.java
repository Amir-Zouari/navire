package com.example.navire_backend.persistence.entities;

import com.example.navire_backend.persistence.DTO.ArmateurDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Armateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String manager;
    private String operationDep;
    private String email;
    private int tel;
    private String fax;
    @OneToMany(mappedBy = "armateur", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Navire> listNavire = new ArrayList<>();
    @OneToMany(mappedBy = "armateur", cascade = CascadeType.ALL)
    private List<MenInCharge> listMenInCharge = new ArrayList<>();

    public ArmateurDTO toDTO() {
        ArmateurDTO armateurDTO = new ArmateurDTO();
        armateurDTO.setId(this.id);
        armateurDTO.setNom(this.nom);
        armateurDTO.setManager(this.manager);
        armateurDTO.setOperationDep(this.operationDep);
        armateurDTO.setEmail(this.email);
        armateurDTO.setTel(this.tel);
        armateurDTO.setFax(this.fax);


        List<Integer> listNavireId = this.listNavire.stream()
                .map(Navire::getId)
                .collect(Collectors.toList());
        armateurDTO.setListNavireId(listNavireId);


        armateurDTO.setListMenInCharge(this.listMenInCharge);

        return armateurDTO;
    }

}

