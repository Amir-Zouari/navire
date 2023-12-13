package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.IReceptionneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionneurService implements IReceptionneur {
    @Autowired
    ReceptionneurRepository receptionneurRepository;
    @Override
    public Receptionneur saveReceptionneur(Receptionneur receptionneur) {
        if(receptionneur.getNom()==null) receptionneur.setNom("");
        if(receptionneur.getPrenom()==null) receptionneur.setPrenom("");
        if(receptionneur.getCargaisonRec()==null) receptionneur.setCargaisonRec(new ArrayList<>());
        return receptionneurRepository.save(receptionneur);
    }

    @Override
    public Receptionneur updateReceptionneur(int id,Receptionneur receptionneur) {
        Receptionneur r = receptionneurRepository.findById(id).get();
        r.setNom(receptionneur.getNom());
        r.setPrenom(receptionneur.getPrenom());
        r.setTel(receptionneur.getTel());
        r.setNavire(receptionneur.getNavire());
        r.setCargaisonRec(receptionneur.getCargaisonRec());
        return receptionneurRepository.save(r);
    }

    @Override
    public void deleteReceptionneur(int id) {
        receptionneurRepository.deleteById(id);
    }

    @Override
    public List<Receptionneur> getListReceptionneur() {
        return receptionneurRepository.findAll();
    }


    @Override
    public List<Receptionneur> findReceptionneurByName(String name) {
        return receptionneurRepository.findAllByPrenom(name);
    }

    @Override
    public Receptionneur getReceptionneurById(int id) {
        return receptionneurRepository.findById(id).get();
    }

    @Override
    public List<Receptionneur> getReceptionneurByPrenomNom(String prenom, String nom) {
        return receptionneurRepository.findAllByPrenomAndNom(prenom,nom);
    }

    @Override
    public int getQuantityOfReceptionneur() {
        return 0;
    }



}
