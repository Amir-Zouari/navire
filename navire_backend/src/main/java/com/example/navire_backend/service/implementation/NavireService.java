package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.INavire;

import java.util.List;

public class NavireService implements INavire {
    @Override
    public Navire saveNavire(Navire navire) {
        return null;
    }

    @Override
    public Navire updateNavire(Navire navire) {
        return null;
    }

    @Override
    public boolean deleteNavire(Long id) {
        return false;
    }

    @Override
    public List<Navire> getListNavire() {
        return null;
    }

    @Override
    public Navire getNavire(Long id) {
        return null;
    }

    @Override
    public Navire findNavireByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfNavire() {
        return 0;
    }

    @Override
    public Navire getNavireByIdNavire(Long id) {
        return null;
    }
}
