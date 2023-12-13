package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.ArmateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/armateur")
public class ArmateurController {
    @Autowired
    private ArmateurRepository armateurRepository;
    // CRUD Methods
}
