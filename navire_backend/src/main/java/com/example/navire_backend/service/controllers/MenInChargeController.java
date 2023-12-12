package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.MenInChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menInCharge")
public class MenInChargeController {
    @Autowired
    private MenInChargeRepository menInChargeRepository;
    // CRUD Methods
}

