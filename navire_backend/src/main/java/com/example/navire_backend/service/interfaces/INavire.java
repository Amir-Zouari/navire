package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Navire;

import java.util.List;

public interface INavire {
    Navire saveNavire(Navire navire);

    Navire updateNavire(Navire navire);

    boolean deleteNavire(Long id);

    List<Navire> getListNavire();

    Navire getNavire(Long id);

    Navire findNavireByName(String name);

    int getQuantityOfNavire();

    Navire getNavireByIdNavire(Long id);
}
