package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.CargaisonNavDTO;
import com.example.navire_backend.persistence.dao.CargaisonNavRepository;
import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.entities.CargaisonNav;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.ICargaisonNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargaisonNavService implements ICargaisonNav {
    @Autowired
    CargaisonNavRepository cargaisonNavRepository;
    @Autowired
    NavireRepository navireRepository;
    @Override
    public CargaisonNav saveCargaisonNav(CargaisonNav cargaisonNav) {
        Navire navire = cargaisonNav.getNavire();
        if (navire != null && navire.getId() == 0) {
            navireRepository.saveAndFlush(navire);
        }
        return cargaisonNavRepository.save(cargaisonNav);
    }

    @Override
    public CargaisonNav updateCargaisonNav(int id,CargaisonNav updatedCargaisonNav) {
        CargaisonNav existingCargaisonNav = cargaisonNavRepository.findById(id).orElse(null);

        if (existingCargaisonNav != null) {
            Navire navire = updatedCargaisonNav.getNavire();
            if (navire != null) {
               navireRepository.saveAndFlush(navire);
            }

            if (updatedCargaisonNav.getTonnage() != 0)existingCargaisonNav.setTonnage(updatedCargaisonNav.getTonnage());
            if (updatedCargaisonNav.getType() != null) existingCargaisonNav.setType(updatedCargaisonNav.getType());
            if (updatedCargaisonNav.getNavire() != null)existingCargaisonNav.setNavire(navire);
            return cargaisonNavRepository.save(existingCargaisonNav);

        } else {
            return null;
        }
    }

    @Override
    public void deleteCargaisonNav(int id) {
        cargaisonNavRepository.deleteById(id);
    }

    @Override
    public List<CargaisonNavDTO> getListCargaisonNav() {
        List<CargaisonNav> cargaisonNavList = cargaisonNavRepository.findAll();
        return cargaisonNavList.stream()
                .map(CargaisonNav::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CargaisonNavDTO getCargaisonNavById(int id) {
        CargaisonNav cargaisonNav = cargaisonNavRepository.findById(id).get();
        return cargaisonNav.toDTO();
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
