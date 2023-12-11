package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ouvrier")
public class OuvrierController {
    @Autowired
    private OuvrierRepository ouvrierRepository;
    // CRUD Methods
}

