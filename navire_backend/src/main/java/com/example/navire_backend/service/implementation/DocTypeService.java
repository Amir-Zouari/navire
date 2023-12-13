package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.DocTypeRepository;
import com.example.navire_backend.persistence.entities.DocType;
import com.example.navire_backend.service.interfaces.IDocType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocTypeService implements IDocType {
    @Autowired
    DocTypeRepository docTypeRepository;
    @Override
    public DocType saveDocType(DocType docType) {
        if (docType.getNom()==null) docType.setNom("");
        return docTypeRepository.save(docType);
    }
    @Override
    public void deleteDocType(int id) {
        docTypeRepository.deleteById(id);
    }
    @Override
    public DocType updateDocType(DocType docType) {
        return null;
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
