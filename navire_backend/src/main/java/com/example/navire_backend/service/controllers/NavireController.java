package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.service.interfaces.INavire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navire")
public class NavireController {
    @Autowired
    INavire navireService;

    @RequestMapping(path = "/add",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Navire ajouterNavire(@RequestBody Navire navire) {
        return navireService.saveNavire(navire);
    }

    @GetMapping("/byId/{navId}")
    Navire getNavireById(@PathVariable int navId){
        return navireService.getNavireById(navId);
    }

    @GetMapping("/all")
    List<Navire> getAllNavire(){
        return navireService.getListNavire();
    }
    @PutMapping("/update/{navId}")
    Navire modifierNavire(@PathVariable int navId,@RequestBody Navire updateRequest){
    return navireService.updateNavire(navId,updateRequest);
    }

    @DeleteMapping("/delete/{navId}")
    void supprimerNavire(@PathVariable int navId){
        navireService.deleteNavire(navId);
    }

    @GetMapping("/byNom/{navNom}")
    List<Navire> getNavireByNom(@PathVariable String navNom){
       return navireService.getNavireBynom(navNom);
    }




}
