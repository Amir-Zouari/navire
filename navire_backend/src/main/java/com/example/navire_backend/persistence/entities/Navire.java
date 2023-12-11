package com.example.navire_backend.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Navire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNav;
    private int nEscales;
    private Date dateEntre;
    private Date dateSortie;
    private String etat;
    private String port;

    @OneToMany(mappedBy = "Navire",fetch = FetchType.LAZY)
    private List<Receptionneur> listReceptionneur;

    @OneToMany(mappedBy = "Navire",fetch = FetchType.LAZY)
    private List<DocType> listDocType;

    @OneToMany(mappedBy = "Navire",fetch = FetchType.LAZY)
    private List<CargaisonNav> listCargaisonNav;

    @ManyToOne
    private Armateur armateur;




}
