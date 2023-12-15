package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.dao.DocumentRepository;
import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService implements IDocument {
    @Autowired
    NavireRepository navireRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Override
    public Document saveDocument(Document document) {
        Navire navire = document.getNavire();
        if (navire != null && navire.getId() == 0) {
            navireRepository.saveAndFlush(navire);
        }
        document.setNavire(navire);
        return documentRepository.saveAndFlush(document);
    }
    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }
    @Override
    public Document updateDocument(int id, Document updatedDocument) {
        Document existingDocument = documentRepository.findById(id).orElse(null);

        if (existingDocument != null) {
            Navire navire = updatedDocument.getNavire();
            if (navire != null) {
                navireRepository.saveAndFlush(navire);
            }

            existingDocument.setType(updatedDocument.getType());
            existingDocument.setNavire(navire);
            return documentRepository.save(existingDocument);

        } else {
            return null;
        }
    }



    @Override
    public List<DocumentDTO> getListDocument() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .map(Document::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public DocumentDTO getDocumentById(int id) {
        Document document = documentRepository.findById(id).get();
        return document.toDTO();
    }

    @Override
    public Document findDocTypeByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfDocType() {
        return 0;
    }

    @Override
    public Document getDocTypeByIdDocType(Long id) {
        return null;
    }
}
