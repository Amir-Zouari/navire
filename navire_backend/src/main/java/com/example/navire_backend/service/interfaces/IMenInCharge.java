package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.MenInCharge;

import java.util.List;

public interface IMenInCharge {
    MenInCharge saveMenInCharge(MenInCharge menInCharge);
    MenInCharge updateMenInCharge(MenInCharge menInCharge);
    boolean deleteMenInCharge(Long id);
    List<MenInCharge> getListMenInCharge();
    MenInCharge getMenInCharge(Long id);
    MenInCharge findMenInChargeByName(String name);
    int getQuantityOfMenInCharge();
    MenInCharge getMenInChargeByIdMenInCharge(Long id);
}


