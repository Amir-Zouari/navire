package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.ArmateurDTO;
import com.example.navire_backend.persistence.DTO.CargaisonNavDTO;
import com.example.navire_backend.persistence.DTO.CargaisonRecDTO;
import com.example.navire_backend.persistence.dao.CargaisonNavRepository;
import com.example.navire_backend.persistence.entities.Armateur;
import com.example.navire_backend.persistence.entities.CargaisonNav;
import com.example.navire_backend.persistence.entities.CargaisonRec;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.IArmateur;
import com.example.navire_backend.service.interfaces.ICargaisonNav;
import com.example.navire_backend.service.interfaces.ICargaisonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cargaisonNav")
public class CargaisonNavController {

    @Autowired
    private ICargaisonNav cargaisonNavService;

    @PostMapping("/add")
    public CargaisonNav ajouterCargaisonNav(@RequestBody CargaisonNav cargaisonNav) {
        return cargaisonNavService.saveCargaisonNav(cargaisonNav);
    }

    @DeleteMapping("/delete/{cargNavId}")
    public void supprimerCargaisonNav(@PathVariable int cargNavId) {
        cargaisonNavService.deleteCargaisonNav(cargNavId);
    }

    @GetMapping("/{cargNavId}")
    public CargaisonNavDTO getCargaisonNavById(@PathVariable int cargNavId) {
        return cargaisonNavService.getCargaisonNavById(cargNavId);
    }

    @GetMapping("/all")
    public List<CargaisonNavDTO> getAllCargaisonNav() {
        return cargaisonNavService.getListCargaisonNav();
    }

    @PutMapping("/update/{cargNavId}")
    public CargaisonNav modifierCargaisonNav(@PathVariable int cargNavId, @RequestBody CargaisonNav cargaisonNav) {
        return cargaisonNavService.updateCargaisonNav(cargNavId, cargaisonNav);
    }
}

