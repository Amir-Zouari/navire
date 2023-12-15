package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.ArmateurDTO;
import com.example.navire_backend.persistence.dao.ArmateurRepository;
import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.service.interfaces.IArmateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armateur")
public class ArmateurController {

    @Autowired
    private IArmateur armateurService;

    @PostMapping("/add")
    public Armateur ajouterArmateur(@RequestBody Armateur armateur) {
        return armateurService.saveArmateur(armateur);
    }

    @DeleteMapping("/delete/{armateurId}")
    public void supprimerArmateur(@PathVariable int armateurId) {
        armateurService.deleteArmateur(armateurId);
    }

    @GetMapping("/{armateurId}")
    public ArmateurDTO getArmateurById(@PathVariable int armateurId) {
        return armateurService.getArmateurById(armateurId);
    }

    @GetMapping("/all")
    public List<ArmateurDTO> getAllArmateur() {
        return armateurService.getListArmateur();
    }

    @PutMapping("/update/{armateurId}")
    public Armateur modifierArmateur(@PathVariable int armateurId, @RequestBody Armateur updatedArmateur) {
        return armateurService.updateArmateur(armateurId, updatedArmateur);
    }
}