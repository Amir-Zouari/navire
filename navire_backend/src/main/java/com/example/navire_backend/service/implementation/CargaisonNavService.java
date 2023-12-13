package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.CargaisonNavRepository;
import com.example.navire_backend.persistence.entities.CargaisonNav;
import com.example.navire_backend.service.interfaces.ICargaisonNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargaisonNavService implements ICargaisonNav {
    @Autowired
    CargaisonNavRepository cargaisonNavRepository;
    @Override
    public CargaisonNav saveCargaisonNav(CargaisonNav cargaisonNav) {
        if (cargaisonNav.getTypeCar()==null) cargaisonNav.setTypeCar("");
        return cargaisonNavRepository.save(cargaisonNav);
    }

    @Override
    public CargaisonNav updateCargaisonNav(CargaisonNav cargaisonNav) {
        return null;
    }

    @Override
    public void deleteCargaisonNav(int id) {
        cargaisonNavRepository.deleteById(id);
    }

    @Override
    public List<CargaisonNav> getListCargaisonNav() {
        return null;
    }

    @Override
    public CargaisonNav getCargaisonNav(Long id) {
        return null;
    }

    @Override
    public CargaisonNav findCargaisonNavByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfCargaisonNav() {
        return 0;
    }

    @Override
    public CargaisonNav getCargaisonNavByIdCargaisonNav(Long id) {
        return null;
    }
}
