package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.DTO.CargaisonRecDTO;
import com.example.navire_backend.persistence.dao.CargaisonRecRepository;
import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.CargaisonRec;
import com.example.navire_backend.persistence.entities.Document;
import com.example.navire_backend.persistence.entities.Navire;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.ICargaisonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargaisonRecService implements ICargaisonRec {
    @Autowired
    CargaisonRecRepository cargaisonRecRepository;
    @Autowired
    ReceptionneurRepository receptionneurRepository;
    @Override
    public CargaisonRec saveCargaisonRec(CargaisonRec cargaisonRec) {
        Receptionneur receptionneur = cargaisonRec.getReceptionneur();
        if (receptionneur != null && receptionneur.getId() == 0) {
            receptionneurRepository.saveAndFlush(receptionneur);
        }
        return cargaisonRecRepository.save(cargaisonRec);
    }

    @Override
    public CargaisonRec updateCargaisonRec(int id,CargaisonRec updatedCargaisonRec) {
        /*Optional<CargaisonRec> existingCargaisonRec= cargaisonRecRepository.findById(updatedCargaisonRec.getId());
        if (existingCargaisonRec.isPresent()) updatedCargaisonRec = existingCargaisonRec.get();
        cargaisonRecRepository.saveAndFlush(updatedCargaisonRec);

        if (updatedCargaisonRec.getType() != null) existingCargaisonRec.get().setType(updatedCargaisonRec.getType());
        if (updatedCargaisonRec.getTonnage() != 0) existingCargaisonRec.get().setType(updatedCargaisonRec.getType());
        if (updatedCargaisonRec.getReceptionneur() != null) existingCargaisonRec.get().setType(updatedCargaisonRec.getType());
        return cargaisonRecRepository.save(existingCargaisonRec);

        } else {
            return null;
        }*/
        CargaisonRec existingCargaisonRec = cargaisonRecRepository.findById(id).orElse(null);

        if (existingCargaisonRec != null) {
            Receptionneur receptionneur = updatedCargaisonRec.getReceptionneur();
            if (receptionneur != null) {
                receptionneurRepository.saveAndFlush(receptionneur);
            }

            if (updatedCargaisonRec.getTonnage() != 0)existingCargaisonRec.setTonnage(updatedCargaisonRec.getTonnage());
            if (updatedCargaisonRec.getType() != null) existingCargaisonRec.setType(updatedCargaisonRec.getType());
            if (updatedCargaisonRec.getReceptionneur() != null)existingCargaisonRec.setReceptionneur(receptionneur);
            return cargaisonRecRepository.save(existingCargaisonRec);

        } else {
            return null;
        }
    }

    @Override
    public void deleteCargaisonRec(int id) {
        cargaisonRecRepository.deleteById(id);
    }

    @Override
    public List<CargaisonRecDTO> getListCargaisonRec() {
        List<CargaisonRec> CargaisonRecList = cargaisonRecRepository.findAll();
        return CargaisonRecList.stream()
                .map(CargaisonRec::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CargaisonRecDTO getCargaisonRecById(int id) {
        CargaisonRec cargaisonRec = cargaisonRecRepository.findById(id).get();
        return cargaisonRec.toDTO();
    }

    @Override
    public CargaisonRec findCargaisonRecByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfCargaisonRec() {
        return 0;
    }

    @Override
    public CargaisonRec getCargaisonRecByIdCargaisonRec(Long id) {
        return null;
    }
}
