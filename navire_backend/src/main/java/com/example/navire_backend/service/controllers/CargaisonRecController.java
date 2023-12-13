package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.CargaisonRecRepository;
import com.example.navire_backend.persistence.entities.CargaisonRec;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.implementation.CargaisonRecService;
import com.example.navire_backend.service.interfaces.ICargaisonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cargaisonRec")
public class CargaisonRecController {
    @Autowired
    private ICargaisonRec cargaisonRecService;
    @RequestMapping(path = "/add",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    CargaisonRec ajouterCargaisonRec(@RequestBody CargaisonRec cargaisonRec) {

        return cargaisonRecService.saveCargaisonRec(cargaisonRec);
    }
    @DeleteMapping("/delete/{cargRecId}")
    void supprimerCargaisonRec(@PathVariable int cargRecId){
        cargaisonRecService.deleteCargaisonRec(cargRecId);
    }
}
