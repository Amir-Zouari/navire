package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.ArmateurDTO;
import com.example.navire_backend.persistence.dao.ArmateurRepository;
import com.example.navire_backend.persistence.dao.MenInChargeRepository;
import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.persistence.entities.MenInCharge;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.IArmateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArmateurService implements IArmateur {
    @Autowired
    ArmateurRepository armateurRepository;
    @Autowired
    NavireRepository navireRepository;
    @Autowired
    MenInChargeRepository menInChargeRepository;
    @Override
    public Armateur saveArmateur(Armateur armateur) {
        List<Navire> foundNavireList = armateur.getListNavire();
        if (foundNavireList != null) {
            for (Navire navire : foundNavireList) {
                Optional<Navire> existingNavire = navireRepository.findById(navire.getId());
                if (existingNavire.isPresent()) {
                    navire = existingNavire.get();
                }
                navire.setArmateur(armateur);
            }
        }
        List<MenInCharge> foundMenInChargeList = armateur.getListMenInCharge();
        if (foundMenInChargeList != null) {
            for (MenInCharge menInCharge : foundMenInChargeList) {
                Optional<MenInCharge> existingMenInCharge = menInChargeRepository.findById(menInCharge.getId());
                if (existingMenInCharge.isPresent()) menInCharge = existingMenInCharge.get();
                menInCharge.setArmateur(armateur);
            }

        }


        armateur.setListNavire(new ArrayList<>());
        armateurRepository.saveAndFlush(armateur);
        menInChargeRepository.saveAllAndFlush(foundMenInChargeList);
        navireRepository.saveAllAndFlush(foundNavireList);
        return armateurRepository.findById(armateur.getId()).orElse(null);
    }



    @Override
    public Armateur updateArmateur(int id,Armateur updatedArmateur) {
        Armateur existingArmateur = armateurRepository.findById(id).orElse(null);

        if (existingArmateur != null) {
            if (updatedArmateur.getNom() != null) existingArmateur.setNom(updatedArmateur.getNom());
            if (updatedArmateur.getManager() != null) existingArmateur.setManager(updatedArmateur.getManager());
            if (updatedArmateur.getOperationDep() != null)
                existingArmateur.setOperationDep(updatedArmateur.getOperationDep());
            if (updatedArmateur.getEmail() != null) existingArmateur.setEmail(updatedArmateur.getEmail());
            if (updatedArmateur.getTel() != 0) existingArmateur.setTel(updatedArmateur.getTel());
            if (updatedArmateur.getFax() != null) existingArmateur.setFax(updatedArmateur.getFax());

            List<Navire> updatedNavires = updatedArmateur.getListNavire();
            existingArmateur.getListNavire().clear();
            if (updatedNavires != null) {
                for (Navire updatedNavire : updatedNavires) {
                    Optional<Navire> existingNavire = navireRepository.findById(updatedNavire.getId());
                    if (existingNavire.isPresent()) updatedNavire = existingNavire.get();
                    updatedNavire.setArmateur(existingArmateur);
                    existingArmateur.getListNavire().add(updatedNavire);
                }
            }
            List<MenInCharge> updatedMenInChargeList = updatedArmateur.getListMenInCharge();
            existingArmateur.getListMenInCharge().clear();
            if (updatedMenInChargeList != null) {
                for (MenInCharge updatedMenInCharge : updatedMenInChargeList) {
                    Optional<MenInCharge> existingMenInCharge = menInChargeRepository.findById(updatedMenInCharge.getId());
                    if (existingMenInCharge.isPresent()) updatedMenInCharge = existingMenInCharge.get();
                    updatedMenInCharge.setArmateur(existingArmateur);
                    existingArmateur.getListMenInCharge().add(updatedMenInCharge);
                }
            }
            armateurRepository.saveAndFlush(existingArmateur);
            menInChargeRepository.saveAllAndFlush(existingArmateur.getListMenInCharge());
            return existingArmateur;
        }

     else {
        return null;
    }
    }

    @Override
    public void deleteArmateur(int id) {
        armateurRepository.deleteById(id);
    }

    @Override
    public List<ArmateurDTO> getListArmateur() {
        List<Armateur> armateurList = armateurRepository.findAll();
        return armateurList.stream()
                .map(Armateur::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArmateurDTO getArmateurById(int id) {
        Armateur armateur = armateurRepository.findById(id).get();
        return armateur.toDTO();
    }

    @Override
    public Armateur findArmateurByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfArmateur() {
        return 0;
    }

    @Override
    public Armateur getArmateurByIdArmateur(Long id) {
        return null;
    }
}
