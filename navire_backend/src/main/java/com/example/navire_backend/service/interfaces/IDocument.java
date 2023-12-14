package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.entities.Document;

import java.util.List;

public interface IDocument {
    Document saveDocument(Document document);

    Document updateDocType(Document document);

    void deleteDocument(int id);

    List<Document> getListDocType();

    DocumentDTO getDocumentById(int id);

    Document findDocTypeByName(String name);

    int getQuantityOfDocType();

    Document getDocTypeByIdDocType(Long id);
}
