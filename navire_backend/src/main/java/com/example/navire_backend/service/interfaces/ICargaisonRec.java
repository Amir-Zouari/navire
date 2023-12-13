package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.CargaisonRec;

import java.util.List;

public interface ICargaisonRec {
    CargaisonRec saveCargaisonRec(CargaisonRec cargaisonRec);

    CargaisonRec updateCargaisonRec(int id,CargaisonRec cargaisonRec);

    void deleteCargaisonRec(int id);

    List<CargaisonRec> getListCargaisonRec();

    CargaisonRec getCargaisonRec(Long id);

    CargaisonRec findCargaisonRecByName(String name);

    int getQuantityOfCargaisonRec();

    CargaisonRec getCargaisonRecByIdCargaisonRec(Long id);
}
