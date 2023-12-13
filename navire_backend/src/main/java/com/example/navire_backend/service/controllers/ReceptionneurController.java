package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.IReceptionneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receptionneur")
public class ReceptionneurController {

    @Autowired
    IReceptionneur receptionneurService;

    @PostMapping("/add")
    Receptionneur ajouterReceptionneur(@RequestBody Receptionneur receptionneur) {
        return receptionneurService.saveReceptionneur(receptionneur);
    }

    @GetMapping("/{receptionneurId}")
    Receptionneur getReceptionneurById(@PathVariable int receptionneurId) {
        return receptionneurService.getReceptionneur(receptionneurId);
    }

    @GetMapping("/all")
    List<Receptionneur> getAllReceptionneurs() {
        return receptionneurService.getListReceptionneur();
    }

    @GetMapping("/byName/{receptionneurName}")
    List<Receptionneur> getReceptionneurByName(@PathVariable String receptionneurName) {
        return receptionneurService.findReceptionneurByname(receptionneurName);
    }

    @PutMapping("/update/{receptionneurId}")
    Receptionneur modifierReceptionneur(@PathVariable int receptionneurId, @RequestBody Receptionneur updateRequest) {
        return receptionneurService.updateReceptionneur(receptionneurId, updateRequest);
    }

    @DeleteMapping("/delete/{receptionneurId}")
    void supprimerReceptionneur(@PathVariable int receptionneurId) {
        receptionneurService.deleteReceptionneur(receptionneurId);
    }

    // Additional endpoints if needed

}
