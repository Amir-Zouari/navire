package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.NavireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/navire")
public class NavireController {
    @Autowired
    private NavireRepository navireRepository;
    // CRUD Methods
}
