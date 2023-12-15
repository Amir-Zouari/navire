package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.*;
import com.example.navire_backend.persistence.entities.*;
import com.example.navire_backend.service.interfaces.INavire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NavireService implements INavire {

    @Autowired
    NavireRepository navireRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    ReceptionneurRepository receptionneurRepository;
    @Autowired
    CargaisonNavRepository cargaisonNavRepository;
    @Autowired
    CargaisonRecRepository cargaisonRecRepository;
    @Override
    public Navire saveNavire(Navire navire) {
        List<Document> foundDocList = navire.getListDocument();
        if (foundDocList != null){
            for (Document document : foundDocList) {
                Optional <Document> existingDocument = documentRepository.findById(document.getId());
                if (existingDocument.isPresent()) document = existingDocument.get();
                document.setNavire(navire);

            }
        }
        List<CargaisonNav> foundCargNavList = navire.getListCargaisonNav();
        if (foundCargNavList != null){
            for (CargaisonNav cargaisonNav : foundCargNavList) {
                Optional<CargaisonNav> existingCargNav = cargaisonNavRepository.findById(cargaisonNav.getId());
                if (existingCargNav.isPresent()) cargaisonNav = existingCargNav.get();
                cargaisonNav.setNavire(navire);

            }
        }

        List<Receptionneur> foundReceptionneurs = navire.getListReceptionneur();
        if (foundReceptionneurs != null) {
            for (Receptionneur receptionneur : foundReceptionneurs) {
                /*Optional<Receptionneur> existingReceptionneur = receptionneurRepository.findById(receptionneur.getId());
                if (existingReceptionneur.isPresent()) receptionneur = existingReceptionneur.get();*/
                receptionneur.getListCargaisonRec().clear();

                List<CargaisonRec> foundCargaisonRecs = receptionneur.getListCargaisonRec();
                if (foundCargaisonRecs != null) {
                    for (CargaisonRec cargaisonRec : foundCargaisonRecs) {
                        cargaisonRec.setReceptionneur(receptionneur);
                        receptionneur.getListCargaisonRec().add(cargaisonRec);
                    }
                }
                receptionneur.setNavire(navire);

            }
        }

        navire.setListDocument(new ArrayList<>());
        List<Receptionneur> foundRecList = navire.getListReceptionneur();
        if(foundRecList != null){
            for (Receptionneur receptionneur : foundRecList) {
                Optional<Receptionneur> existingReceptionneur = receptionneurRepository.findById(receptionneur.getId());
                if (existingReceptionneur.isPresent()) receptionneur = existingReceptionneur.get();
                receptionneur.setNavire(navire);

            }
        }
        navire.setListReceptionneur(new ArrayList<>());
        navire.setListDocument(new ArrayList<>());
        navireRepository.saveAndFlush(navire);
        cargaisonNavRepository.saveAllAndFlush(foundCargNavList);
        receptionneurRepository.saveAllAndFlush(foundRecList);
        documentRepository.saveAllAndFlush(foundDocList);
        return navireRepository.findById(navire.getId()).get();
    }

    @Override
    public Navire updateNavire(int id,Navire updatedNavire) {

        Navire existingNavire = navireRepository.findById(id).orElse(null);

        if (existingNavire != null) {
            if (updatedNavire.getEtat() != null) existingNavire.setEtat(updatedNavire.getEtat());
            if (updatedNavire.getPort() != null)existingNavire.setPort(updatedNavire.getPort());
            if (updatedNavire.getDateSortie() != null)existingNavire.setDateSortie(updatedNavire.getDateSortie());
            if (updatedNavire.getDateEntre() != null)existingNavire.setDateEntre(updatedNavire.getDateEntre());
            if (updatedNavire.getNom() != null)existingNavire.setNom(updatedNavire.getNom());
            if (updatedNavire.getNEscales() != 0)existingNavire.setNEscales(updatedNavire.getNEscales());
            if (updatedNavire.getArmateur() != null)existingNavire.setArmateur(updatedNavire.getArmateur());


            List<Document> updatedDocuments = updatedNavire.getListDocument();

            existingNavire.getListDocument().clear();
            if (updatedDocuments != null) {
                for (Document updatedDocument : updatedDocuments) {
                    Optional <Document> existingDocument = documentRepository.findById(updatedDocument.getId());
                    if (existingDocument.isPresent()) updatedDocument = existingDocument.get();
                    updatedDocument.setNavire(existingNavire);
                    existingNavire.getListDocument().add(updatedDocument);
                }
            }

            List<Receptionneur> updatedReceptionneurs = updatedNavire.getListReceptionneur();
            existingNavire.getListReceptionneur().clear();
            if (updatedReceptionneurs != null) {
                for (Receptionneur updatedReceptionneur : updatedReceptionneurs) {
                    List<CargaisonRec> updatedCargaisonRecList = updatedReceptionneur.getListCargaisonRec();
                    /*Optional<Receptionneur> existingReceptionneur = receptionneurRepository.findById(updatedReceptionneur.getId());
                    if (existingReceptionneur.isPresent()) updatedReceptionneur = existingReceptionneur.get();*/
                    updatedReceptionneur.getListCargaisonRec().clear();

                    if (updatedCargaisonRecList != null) {
                        for (CargaisonRec updatedCargaisonRec : updatedCargaisonRecList) {
                            Optional<CargaisonRec> existingCargRec = cargaisonRecRepository.findById(updatedCargaisonRec.getId());
                            if (existingCargRec.isPresent()) {
                                // If the CargaisonRec exists, use the existing one
                                updatedCargaisonRec = existingCargRec.get();
                            } else {
                                // If it doesn't exist, set the reference to the existing Receptionneur
                                updatedCargaisonRec.setReceptionneur(updatedReceptionneur);
                            }

                            // Set the reference to the existing Receptionneur
                            updatedCargaisonRec.setReceptionneur(updatedReceptionneur);
                            updatedReceptionneur.getListCargaisonRec().add(updatedCargaisonRec);
                        }
                    }
                    updatedReceptionneur.setNavire(existingNavire);
                    existingNavire.getListReceptionneur().add(updatedReceptionneur);
                }
            }

            List<CargaisonNav> updatedCargaisonNavs = updatedNavire.getListCargaisonNav();
            existingNavire.getListCargaisonNav().clear();
            if (updatedCargaisonNavs != null) {
                for (CargaisonNav updatedCargaisonNav : updatedCargaisonNavs) {
                    Optional<CargaisonNav> existingCargNav = cargaisonNavRepository.findById(updatedCargaisonNav.getId());
                    if (existingCargNav.isPresent()) updatedCargaisonNav = existingCargNav.get();
                    updatedCargaisonNav.setNavire(existingNavire);
                    existingNavire.getListCargaisonNav().add(updatedCargaisonNav);
                }
            }

            navireRepository.saveAndFlush(existingNavire);
            cargaisonNavRepository.saveAllAndFlush(existingNavire.getListCargaisonNav());
            documentRepository.saveAllAndFlush(existingNavire.getListDocument());
            receptionneurRepository.saveAllAndFlush(existingNavire.getListReceptionneur());
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
