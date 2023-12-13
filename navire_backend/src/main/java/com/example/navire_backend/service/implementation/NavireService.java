package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.INavire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class NavireService implements INavire {

    @Autowired
    NavireRepository navireRepository;
    @Override
    public Navire saveNavire(Navire navire) {

        if (navire.getEtat() == null) navire.setEtat("");

        if (navire.getListReceptionneur() == null) {
            navire.setListReceptionneur(new ArrayList<>());
        }

        if (navire.getListDocType() == null) {
            navire.setListDocType(new ArrayList<>());
        }

        if (navire.getListCargaisonNav() == null) {
            navire.setListCargaisonNav(new ArrayList<>());
        }
        if(navire.getArmateur()==null) navire.setArmateur(new Armateur());


        if(navire.getPort()==null) navire.setPort("");
        if(navire.getNom()==null) navire.setNom("");

        return navireRepository.save(navire);
    }

    @Override
    public Navire updateNavire(int id,Navire navire) {
        Navire n = navireRepository.findById(id).get();
        n.setEtat(navire.getEtat());
        n.setPort(navire.getPort());
        n.setDateSortie(navire.getDateSortie());
        n.setDateEntre(navire.getDateEntre());
        n.setNom(navire.getNom());
        n.setNEscales(navire.getNEscales());
        n.setArmateur(navire.getArmateur());
        n.setListCargaisonNav(navire.getListCargaisonNav());
        n.setListDocType(navire.getListDocType());
        n.setListReceptionneur(navire.getListReceptionneur());
        navireRepository.save(n);
        return navireRepository.findById(id).get();
    }

    @Override
    public List<Navire> getListNavire() {
        return navireRepository.findAll();
    }

    @Override
    public void deleteNavire(int id) {
        navireRepository.deleteById(id);
    }


    @Override
    public Navire getNavireById(int id) {
        return navireRepository.findById(id).get();
    }

    @Override
    public List<Navire> getNavireBynom(String name){
        return navireRepository.findAllByNom(name);
    }

    @Override
    public int getQuantityOfNavire() {
        return 0;
    }

}
