package com.example.navire_backend.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Setter
public class Navire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNav;
    private String navName;
    private int nEscales;
    private Date dateEntre;
    private Date dateSortie;
    private String etat;
    private String port;

    @OneToMany(mappedBy = "navire",fetch = FetchType.LAZY)
    private List<Receptionneur> listReceptionneur;

    @OneToMany(mappedBy = "navire",fetch = FetchType.LAZY)
    private List<DocType> listDocType;

    @OneToMany(mappedBy = "navire",fetch = FetchType.LAZY)
    private List<CargaisonNav> listCargaisonNav;

    @ManyToOne
    private Armateur armateur;

    public int getIdNav() {
        return idNav;
    }

    public int getnEscales() {
        return nEscales;
    }

    public Date getDateEntre() {
        return dateEntre;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public String getEtat() {
        return etat;
    }

    public String getPort() {
        return port;
    }

    public List<Receptionneur> getListReceptionneur() {
        return listReceptionneur;
    }

    public List<DocType> getListDocType() {
        return listDocType;
    }

    public List<CargaisonNav> getListCargaisonNav() {
        return listCargaisonNav;
    }

    public Armateur getArmateur() {
        return armateur;
    }
}
