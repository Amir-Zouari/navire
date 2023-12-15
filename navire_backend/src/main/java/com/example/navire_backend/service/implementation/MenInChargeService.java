package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.MenInChargeDTO;
import com.example.navire_backend.persistence.dao.ArmateurRepository;
import com.example.navire_backend.persistence.dao.MenInChargeRepository;
import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.persistence.entities.MenInCharge;
import com.example.navire_backend.service.interfaces.IMenInCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenInChargeService implements IMenInCharge {
    @Autowired
    ArmateurRepository armateurRepository;
    @Autowired
    MenInChargeRepository menInChargeRepository;
    @Override
    public MenInCharge saveMenInCharge(MenInCharge menInCharge) {
        Armateur armateur = menInCharge.getArmateur();
        if (armateur != null && armateur.getId() == 0) {
            armateurRepository.saveAndFlush(armateur);
        }
        menInCharge.setArmateur(armateur);
        return menInChargeRepository.saveAndFlush(menInCharge);
    }


    @Override
    public MenInCharge updateMenInCharge(int id,MenInCharge updatedMenInCharge) {
        MenInCharge existingDocument = menInChargeRepository.findById(id).orElse(null);

        if (existingDocument != null) {
            Armateur armateur = updatedMenInCharge.getArmateur();
            if (armateur != null) {
                armateurRepository.saveAndFlush(armateur);
            }
            existingDocument.setNom(updatedMenInCharge.getNom());
            existingDocument.setPrenom(updatedMenInCharge.getPrenom());
            existingDocument.setTel(updatedMenInCharge.getTel());
            existingDocument.setArmateur(armateur);
            return menInChargeRepository.save(existingDocument);

        } else {
            return null;
        }
    }

    @Override
    public void deleteMenInCharge(int id) {
        menInChargeRepository.deleteById(id); ;
    }

    @Override
    public List<MenInChargeDTO> getListMenInCharge() {
        List<MenInCharge>  menInChargeList = menInChargeRepository.findAll();
        return menInChargeList.stream()
                .map(MenInCharge::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenInChargeDTO getMenInChargeById(int id) {
        MenInCharge menInCharge = menInChargeRepository.findById(id).get();
        return  menInCharge.toDTO();
    }

    @Override
    public MenInCharge findMenInChargeByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfMenInCharge() {
        return 0;
    }

    @Override
    public MenInCharge getMenInChargeByIdMenInCharge(Long id) {
        return null;
    }

}
