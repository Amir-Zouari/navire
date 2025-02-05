package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.ReceptionneurDTO;
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

    @GetMapping("/byId/{receptionneurId}")
    ReceptionneurDTO getReceptionneurById(@PathVariable int receptionneurId) {
        return receptionneurService.getReceptionneurById(receptionneurId);
    }

    @GetMapping("/all")
    List<ReceptionneurDTO> getAllReceptionneurs() {
        return receptionneurService.getListReceptionneur();
    }

    @GetMapping("/byNom/{receptionneurName}")
    List<ReceptionneurDTO> getReceptionneurByName(@PathVariable String receptionneurName) {
        return receptionneurService.findReceptionneurByName(receptionneurName);
    }

    @PutMapping("/update/{receptionneurId}")
    Receptionneur modifierReceptionneur(@PathVariable int receptionneurId, @RequestBody Receptionneur updateRequest) {
        return receptionneurService.updateReceptionneur(receptionneurId, updateRequest);
    }

    @DeleteMapping("/delete/{receptionneurId}")
    void supprimerReceptionneur(@PathVariable int receptionneurId) {
        receptionneurService.deleteReceptionneur(receptionneurId);
    }
    @GetMapping("/byPrenomNom")
    public List<ReceptionneurDTO> getRecepetionneurByPrenomNom(
            @RequestParam(name = "prenom") String prenom,
            @RequestParam(name = "nom") String nom) {


        return receptionneurService.getReceptionneurByPrenomNom(prenom, nom);
    }


}
