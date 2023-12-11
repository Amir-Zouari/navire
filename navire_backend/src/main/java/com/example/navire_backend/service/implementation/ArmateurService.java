package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.service.interfaces.IArmateur;
import java.util.List;

public class ArmateurService implements IArmateur {
    @Override
    public Armateur saveArmateur(Armateur armateur) {
        return null;
    }

    @Override
    public Armateur updateArmateur(Armateur armateur) {
        return null;
    }

    @Override
    public boolean deleteArmateur(Long id) {
        return false;
    }

    @Override
    public List<Armateur> getListArmateur() {
        return null;
    }

    @Override
    public Armateur getArmateur(Long id) {
        return null;
    }

    @Override
    public Armateur findArmateurByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfArmateur() {
        return 0;
    }

    @Override
    public Armateur getArmateurByIdArmateur(Long id) {
        return null;
    }
}
