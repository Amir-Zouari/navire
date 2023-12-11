package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Armateur;

import java.util.List;

public interface IArmateur {
    Armateur saveArmateur(Armateur armateur);

    Armateur updateArmateur(Armateur armateur);

    boolean deleteArmateur(Long id);

    List<Armateur> getListArmateur();

    Armateur getArmateur(Long id);

    Armateur findArmateurByName(String name);

    int getQuantityOfArmateur();

    Armateur getArmateurByIdArmateur(Long id);
}
