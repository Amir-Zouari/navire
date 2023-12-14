package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.dao.DocumentRepository;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.service.interfaces.IDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements IDocument {
    @Autowired
    DocumentRepository documentRepository;
    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }
    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }
    @Override
    public Document updateDocType(Document document) {
        return null;
    }



    @Override
    public List<Document> getListDocType() {
        return null;
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
