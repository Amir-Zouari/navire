package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.DTO.ArmateurDTO;
import com.example.navire_backend.persistence.entities.Armateur;

import java.util.List;

public interface IArmateur {
    Armateur saveArmateur(Armateur armateur);

    Armateur updateArmateur(int id,Armateur armateur);

    void deleteArmateur(int id);

    List<ArmateurDTO> getListArmateur();

    ArmateurDTO getArmateurById(int id);

    Armateur findArmateurByName(String name);

    int getQuantityOfArmateur();

    Armateur getArmateurByIdArmateur(Long id);
}
