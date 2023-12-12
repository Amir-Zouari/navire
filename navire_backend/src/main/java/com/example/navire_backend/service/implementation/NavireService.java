package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.INavire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavireService implements INavire {

    @Autowired
    NavireRepository navireRepository;
    @Override
    public Navire saveNavire(Navire navire) {
        return navireRepository.save(navire);
    }

    @Override
    public Navire updateNavire(int id,Navire navire) {
        Navire n = navireRepository.findById(id).get();
        n.setEtat(navire.getEtat());
        n.setPort(navire.getPort());
        n.setDateSortie(navire.getDateSortie());
        n.setDateEntre(navire.getDateEntre());
        n.setNavName(navire.getNavName());
        n.setNEscales(navire.getnEscales());
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
    public Navire getNavire(int id) {
        return navireRepository.findById(id).get();
    }

    @Override
    public Navire findNavireByName(String name) {
            return navireRepository.findByNavName(name);
    }

    @Override
    public int getQuantityOfNavire() {
        return 0;
    }

    @Override
    public Navire getNavireByIdNavire(int id) {
        return null;
    }
}
