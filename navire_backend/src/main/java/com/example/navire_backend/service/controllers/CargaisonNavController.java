package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.CargaisonNavDTO;
import com.example.navire_backend.persistence.DTO.CargaisonRecDTO;
import com.example.navire_backend.persistence.dao.CargaisonNavRepository;
import com.example.navire_backend.persistence.entities.CargaisonNav;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.ICargaisonNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargaisonNav")
public class CargaisonNavController {
    @Autowired
    private ICargaisonNav cargaisonNavService;
    @RequestMapping(path = "/add",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    CargaisonNav ajouterCargaisonNav(@RequestBody CargaisonNav cargaisonNav) {
        return cargaisonNavService.saveCargaisonNav(cargaisonNav);
    }
    @DeleteMapping("/delete/{cargNavId}")
    void supprimerCargaisonNav(@PathVariable int cargNavId){
        cargaisonNavService.deleteCargaisonNav(cargNavId);
    }
    @GetMapping("/{cargRecId}")
    CargaisonNavDTO getCargNavById(@PathVariable int cargRecId){
        return cargaisonNavService.getCargaisonNavById(cargRecId);
    }
    @GetMapping("/all")
    List<CargaisonNavDTO> getAllCargNav(){
        return cargaisonNavService.getListCargaisonNav();
    }

    @PutMapping("/update/{cargNavId}")
    CargaisonNav modifierCargaisonNav(@PathVariable int cargNavId ,@RequestBody CargaisonNav cargaisonNav){
        return cargaisonNavService.updateCargaisonNav(cargNavId,cargaisonNav);
    }


}
