package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.DocType;

import java.util.List;

public interface IDocType {
    DocType saveDocType(DocType docType);

    DocType updateDocType(DocType docType);

    void deleteDocType(int id);

    List<DocType> getListDocType();

    DocType getDocType(Long id);

    DocType findDocTypeByName(String name);

    int getQuantityOfDocType();

    DocType getDocTypeByIdDocType(Long id);
}
