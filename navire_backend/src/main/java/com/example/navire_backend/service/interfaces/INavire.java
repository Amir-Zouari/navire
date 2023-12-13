package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Navire;

import java.util.List;

public interface INavire {

    Navire updateNavire(int id,Navire navire);

    List<Navire> getListNavire();

    Navire saveNavire(Navire navire);

    void deleteNavire(int id);

    Navire getNavireById(int id);


    List getNavireBynom(String name);

    int getQuantityOfNavire();


}
