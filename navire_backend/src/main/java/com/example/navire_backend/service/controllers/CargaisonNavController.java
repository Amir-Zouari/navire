package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.CargaisonNavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cargaisonNav")
public class CargaisonNavController {
    @Autowired
    private CargaisonNavRepository cargaisonNavRepository;
    // CRUD Methods
}
