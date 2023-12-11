package com.example.navire_backend.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

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

}
