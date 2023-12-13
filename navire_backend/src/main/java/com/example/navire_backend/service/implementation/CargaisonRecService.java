package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.dao.CargaisonRecRepository;
import com.example.navire_backend.persistence.dao.ReceptionneurRepository;
import com.example.navire_backend.persistence.entities.CargaisonRec;
import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.ICargaisonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargaisonRecService implements ICargaisonRec {
    @Autowired
    CargaisonRecRepository cargaisonRecRepository;
    @Override
    public CargaisonRec saveCargaisonRec(CargaisonRec cargaisonRec) {
        if(cargaisonRec.getTypeCar()==null) cargaisonRec.setTypeCar("");
        /*if(cargaisonRec.getTonnage()==null) cargaisonRec.setTonnage(0.0);*/
        return cargaisonRecRepository.save(cargaisonRec);
    }

    @Override
    public CargaisonRec updateCargaisonRec(int id,CargaisonRec cargaisonRec) {
        CargaisonRec c = cargaisonRecRepository.findById(id).get();
        c.setTypeCar(cargaisonRec.getTypeCar());
        c.setTonnage(cargaisonRec.getTonnage());
        c.setReceptionneur(cargaisonRec.getReceptionneur());
        return cargaisonRecRepository.save(c);
    }

    @Override
    public void deleteCargaisonRec(int id) {
        cargaisonRecRepository.deleteById(id);
    }

    @Override
    public List<CargaisonRec> getListCargaisonRec() {
        return null;
    }

    @Override
    public CargaisonRec getCargaisonRec(Long id) {
        return null;
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
