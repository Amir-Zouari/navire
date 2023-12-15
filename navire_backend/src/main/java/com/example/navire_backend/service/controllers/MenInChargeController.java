package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.MenInChargeDTO;
import com.example.navire_backend.persistence.dao.MenInChargeRepository;
import com.example.navire_backend.persistence.entities.MenInCharge;
import com.example.navire_backend.service.interfaces.IMenInCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menincharge")
public class MenInChargeController {

    @Autowired
    private IMenInCharge menInChargeService;

    @PostMapping("/add")
    public MenInCharge ajouterMenInCharge(@RequestBody MenInCharge menInCharge) {
        return menInChargeService.saveMenInCharge(menInCharge);
    }

    @DeleteMapping("/delete/{menInChargeId}")
    public void supprimerMenInCharge(@PathVariable int menInChargeId) {
        menInChargeService.deleteMenInCharge(menInChargeId);
    }

    @GetMapping("/{menInChargeId}")
    public MenInChargeDTO getMenInChargeById(@PathVariable int menInChargeId) {
        return menInChargeService.getMenInChargeById(menInChargeId);
    }

    @GetMapping("/all")
    public List<MenInChargeDTO> getAllMenInCharge() {
        return menInChargeService.getListMenInCharge();
    }

    @PutMapping("/update/{menInChargeId}")
    public MenInCharge modifierMenInCharge(@PathVariable int menInChargeId, @RequestBody MenInCharge updatedMenInCharge) {
        return menInChargeService.updateMenInCharge(menInChargeId, updatedMenInCharge);
    }
}


