package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.Ouvrier;
import com.example.navire_backend.service.interfaces.IOuvrier;

import java.util.List;

public class OuvrierService implements IOuvrier {
    @Override
    public Ouvrier saveOuvrier(Ouvrier ouvrier) {
        return null;
    }

    @Override
    public Ouvrier updateOuvrier(Ouvrier ouvrier) {
        return null;
    }

    @Override
    public boolean deleteOuvrier(Long id) {
        return false;
    }

    @Override
    public List<Ouvrier> getListOuvrier() {
        return null;
    }

    @Override
    public Ouvrier getOuvrier(Long id) {
        return null;
    }

    @Override
    public Ouvrier findOuvrierByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfOuvrier() {
        return 0;
    }

    @Override
    public Ouvrier getOuvrierByIdOuvrier(Long id) {
        return null;
    }

}
