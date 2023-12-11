package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.CargaisonRecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargaisonRec")
public class CargaisonRecController {
    @Autowired
    private CargaisonRecRepository cargaisonRecRepository;
    // CRUD Methods
}
