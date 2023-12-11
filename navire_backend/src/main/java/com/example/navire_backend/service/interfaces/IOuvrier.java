package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Ouvrier;

import java.util.List;

public interface IOuvrier {
    Ouvrier saveOuvrier(Ouvrier ouvrier);
    Ouvrier updateOuvrier(Ouvrier ouvrier);
    boolean deleteOuvrier(Long id);
    List<Ouvrier> getListOuvrier();
    Ouvrier getOuvrier(Long id);
    Ouvrier findOuvrierByName(String name);
    int getQuantityOfOuvrier();
    Ouvrier getOuvrierByIdOuvrier(Long id);
}


