package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.dao.DocTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docType")
public class DocTypeController {
    @Autowired
    private DocTypeRepository docTypeRepository;
    // CRUD Methods
}
