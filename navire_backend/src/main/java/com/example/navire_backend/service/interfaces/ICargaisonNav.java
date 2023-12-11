package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.CargaisonNav;

import java.util.List;

public interface ICargaisonNav {
    CargaisonNav saveCargaisonNav(CargaisonNav cargaisonNav);

    CargaisonNav updateCargaisonNav(CargaisonNav cargaisonNav);

    boolean deleteCargaisonNav(Long id);

    List<CargaisonNav> getListCargaisonNav();

    CargaisonNav getCargaisonNav(Long id);

    CargaisonNav findCargaisonNavByName(String name);

    int getQuantityOfCargaisonNav();

    CargaisonNav getCargaisonNavByIdCargaisonNav(Long id);
}
