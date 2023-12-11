package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receptionneur")
public class ReceptionneurController {
    @Autowired
    private ReceptionneurRepository receptionneurRepository;
    // CRUD Methods
}
