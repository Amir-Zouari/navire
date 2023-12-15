package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.ReceptionneurDTO;
import com.example.navire_backend.persistence.dao.CargaisonRecRepository;
import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.CargaisonRec;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.IReceptionneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptionneurService implements IReceptionneur {
    @Autowired
    ReceptionneurRepository receptionneurRepository;
    @Autowired
    CargaisonRecRepository cargaisonRecRepository;
    @Autowired
    NavireRepository navireRepository;
    @Override
    public Receptionneur saveReceptionneur(Receptionneur receptionneur) {
        List<CargaisonRec> foundCargRecList = receptionneur.getListCargaisonRec();
        for (CargaisonRec cargaisonRec : foundCargRecList) {
            cargaisonRec.setReceptionneur(receptionneur);
            receptionneur.setListCargaisonRec(new ArrayList<>());

        }
        Navire navire = receptionneur.getNavire();
        if (navire != null && navire.getId() == 0) {
            navireRepository.saveAndFlush(navire);
        }
        receptionneur.setListCargaisonRec(new ArrayList<>());
        receptionneurRepository.saveAndFlush(receptionneur);
        cargaisonRecRepository.saveAllAndFlush(foundCargRecList);
        return receptionneurRepository.findById(receptionneur.getId()).get();

    }

    @Override
    public Receptionneur updateReceptionneur(int id, Receptionneur updatedReceptionneur) {
        Receptionneur existingReceptionneur = receptionneurRepository.findById(id).orElse(null);

        if (existingReceptionneur != null) {
            Navire navire = updatedReceptionneur.getNavire();
            if (navire != null) {
                navireRepository.save(navire);
            }

            existingReceptionneur.setNom(updatedReceptionneur.getNom() != null ? updatedReceptionneur.getNom() : existingReceptionneur.getNom());
            existingReceptionneur.setPrenom(updatedReceptionneur.getPrenom() != null ? updatedReceptionneur.getPrenom() : existingReceptionneur.getPrenom());
            existingReceptionneur.setTel(updatedReceptionneur.getTel() != 0 ? updatedReceptionneur.getTel() : existingReceptionneur.getTel());

            existingReceptionneur.setNavire(navire);

            List<CargaisonRec> updatedCargaisons = updatedReceptionneur.getListCargaisonRec();
            existingReceptionneur.getListCargaisonRec().clear();
            if (updatedCargaisons != null) {
                for (CargaisonRec updatedCargaison : updatedCargaisons) {
                    updatedCargaison.setReceptionneur(existingReceptionneur);
                    existingReceptionneur.getListCargaisonRec().add(updatedCargaison);
                }
            }


            receptionneurRepository.saveAndFlush(existingReceptionneur);
            cargaisonRecRepository.saveAllAndFlush(existingReceptionneur.getListCargaisonRec());

            return existingReceptionneur;
        } else {

            return null;
        }
    }


    @Override
    public void deleteReceptionneur(int id) {
        receptionneurRepository.deleteById(id);
    }

    @Override
    public List<ReceptionneurDTO> getListReceptionneur() {
        List<Receptionneur> receptionneurs = receptionneurRepository.findAll();

        return receptionneurs.stream()
                .map(Receptionneur::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<ReceptionneurDTO> findReceptionneurByName(String name) {
        List<Receptionneur> receptionneurs = receptionneurRepository.findAllByPrenom(name);
        return receptionneurs.stream()
                .map(Receptionneur::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReceptionneurDTO getReceptionneurById(int id) {
        Receptionneur receptionneur = receptionneurRepository.findById(id).get();
        return receptionneur.toDTO();
    }

    @Override
    public List<ReceptionneurDTO> getReceptionneurByPrenomNom(String prenom, String nom) {
        List<Receptionneur> receptionneurs = receptionneurRepository.findAllByPrenomAndNom(prenom,nom);
        return receptionneurs.stream()
                .map(Receptionneur::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int getQuantityOfReceptionneur() {
        return 0;
    }



}
