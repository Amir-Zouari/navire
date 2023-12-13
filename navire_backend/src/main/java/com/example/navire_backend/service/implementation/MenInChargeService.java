package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.MenInCharge;
import com.example.navire_backend.service.interfaces.IMenInCharge;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenInChargeService implements IMenInCharge {
    @Override
    public MenInCharge saveMenInCharge(MenInCharge menInCharge) {
        return null;
    }

    @Override
    public MenInCharge updateMenInCharge(MenInCharge menInCharge) {
        return null;
    }

    @Override
    public void deleteMenInCharge(int id) {
        return ;
    }

    @Override
    public List<MenInCharge> getListMenInCharge() {
        return null;
    }

    @Override
    public MenInCharge getMenInCharge(Long id) {
        return null;
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
