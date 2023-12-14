package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.DocumentRepository;
import com.example.navire_backend.persistence.dao.NavireRepository;
import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.INavire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavireService implements INavire {

    @Autowired
    NavireRepository navireRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    ReceptionneurRepository receptionneurRepository;
    @Override
    public Navire saveNavire(Navire navire) {
        List<Document> foundDocList = navire.getListDocument();
        for (Document document : foundDocList) {
            document.setNavire(navire);

        }
        navire.setListDocument(new ArrayList<>());

        List<Receptionneur> foundRecList = navire.getListReceptionneur();
        for (Receptionneur receptionneur : foundRecList) {
            receptionneur.setNavire(navire);

        }
        navire.setListReceptionneur(new ArrayList<>());
        navire.setListDocument(new ArrayList<>());
        navireRepository.saveAndFlush(navire);
        documentRepository.saveAllAndFlush(foundDocList);
        receptionneurRepository.saveAllAndFlush(foundRecList);
        return navireRepository.findById(navire.getId()).get();
    }

    @Override
    public Navire updateNavire(int id,Navire updatedNavire) {
        /*Navire n = navireRepository.findById(id).get();

        n.setEtat(navire.getEtat());
        n.setPort(navire.getPort());
        n.setDateSortie(navire.getDateSortie());
        n.setDateEntre(navire.getDateEntre());
        n.setNom(navire.getNom());
        n.setNEscales(navire.getNEscales());
        n.setArmateur(navire.getArmateur());
        n.setListCargaisonNav(navire.getListCargaisonNav());
        n.setListDocument(navire.getListDocument());
        n.setListReceptionneur(navire.getListReceptionneur());
        navireRepository.save(n);
        return navireRepository.findById(id).get();*/
        Navire existingNavire = navireRepository.findById(id).orElse(null);

        if (existingNavire != null) {
            existingNavire.setEtat(updatedNavire.getEtat());
            existingNavire.setPort(updatedNavire.getPort());
            existingNavire.setDateSortie(updatedNavire.getDateSortie());
            existingNavire.setDateEntre(updatedNavire.getDateEntre());
            existingNavire.setNom(updatedNavire.getNom());
            existingNavire.setNEscales(updatedNavire.getNEscales());
            existingNavire.setArmateur(updatedNavire.getArmateur());

            // Update the associated collections
            List<Document> updatedDocuments = updatedNavire.getListDocument();
            existingNavire.getListDocument().clear();
            if (updatedDocuments != null) {
                for (Document updatedDocument : updatedDocuments) {
                    updatedDocument.setNavire(existingNavire);
                    existingNavire.getListDocument().add(updatedDocument);
                }
            }

            List<Receptionneur> updatedReceptionneurs = updatedNavire.getListReceptionneur();
            existingNavire.getListReceptionneur().clear();
            if (updatedReceptionneurs != null) {
                for (Receptionneur updatedReceptionneur : updatedReceptionneurs) {
                    updatedReceptionneur.setNavire(existingNavire);
                    existingNavire.getListReceptionneur().add(updatedReceptionneur);
                }
            }

            navireRepository.save(existingNavire);

            return existingNavire;
        }
        else {
            return null;
        }

    }

    @Override
    public List<Navire> getListNavire() {
        return navireRepository.findAll();
    }

    @Override
    public void deleteNavire(int id) {
        navireRepository.deleteById(id);
    }


    @Override
    public Navire getNavireById(int id) {
        return navireRepository.findById(id).get();
    }

    @Override
    public List<Navire> getNavireBynom(String name){
        return navireRepository.findAllByNom(name);
    }

    @Override
    public int getQuantityOfNavire() {
        return 0;
    }

}
