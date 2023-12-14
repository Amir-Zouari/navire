package com.example.navire_backend.service.controllers;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.service.interfaces.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
    @Autowired
    private IDocument documentService;
    @RequestMapping(path = "/add",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Document ajouterDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }
    @DeleteMapping("/delete/{docId}")
    void supprimerDocument(@PathVariable int docId){
        documentService.deleteDocument(docId);
    }
    @GetMapping("/{docId}")
    DocumentDTO rechercherDocument(@PathVariable int docId){
        return documentService.getDocumentById(docId);
    }


}
