package com.example.navire_backend.persistence.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class Navire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int nEscales;
    private Date dateEntre;
    private Date dateSortie;
    private String etat;
    private String port;


    @OneToMany(mappedBy = "navire", cascade = CascadeType.ALL)
    private List<Receptionneur> listReceptionneur = new ArrayList<>();

    @OneToMany(mappedBy = "navire", cascade = CascadeType.ALL)
    private List<DocType> listDocType = new ArrayList<>();

    @OneToMany(mappedBy = "navire", cascade = CascadeType.ALL)
    private List<CargaisonNav> listCargaisonNav = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "armateur_id")
    private Armateur armateur;

}
