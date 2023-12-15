package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.example.navire_backend.persistence.entities.Document;

import java.util.List;

public interface IDocument {
    Document saveDocument(Document document);

    Document updateDocument(int id,Document document);

    void deleteDocument(int id);

    List<DocumentDTO> getListDocument();

    DocumentDTO getDocumentById(int id);

    Document findDocTypeByName(String name);

    int getQuantityOfDocType();

    Document getDocTypeByIdDocType(Long id);
}
