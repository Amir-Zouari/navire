package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.DTO.CargaisonNavDTO;
import com.example.navire_backend.persistence.entities.CargaisonNav;

import java.util.List;

public interface ICargaisonNav {
    CargaisonNav saveCargaisonNav(CargaisonNav cargaisonNav);

    CargaisonNav updateCargaisonNav(int id ,CargaisonNav cargaisonNav);

    void deleteCargaisonNav(int id);

    List<CargaisonNavDTO> getListCargaisonNav();

    CargaisonNavDTO getCargaisonNavById(int id);

    CargaisonNav findCargaisonNavByName(String name);

    int getQuantityOfCargaisonNav();

    CargaisonNav getCargaisonNavByIdCargaisonNav(Long id);
}
