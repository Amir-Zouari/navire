package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.DocType;
import com.example.navire_backend.service.interfaces.IDocType;

import java.util.List;

public class DocTypeService implements IDocType {
    @Override
    public DocType saveDocType(DocType docType) {
        return null;
    }

    @Override
    public DocType updateDocType(DocType docType) {
        return null;
    }

    @Override
    public boolean deleteDocType(Long id) {
        return false;
    }

    @Override
    public List<DocType> getListDocType() {
        return null;
    }

    @Override
    public DocType getDocType(Long id) {
        return null;
    }

    @Override
    public DocType findDocTypeByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfDocType() {
        return 0;
    }

    @Override
    public DocType getDocTypeByIdDocType(Long id) {
        return null;
    }
}
