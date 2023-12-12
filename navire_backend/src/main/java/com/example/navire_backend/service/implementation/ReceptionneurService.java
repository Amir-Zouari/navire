package com.example.navire_backend.service.implementation;

import com.example.navire_backend.persistence.entities.Receptionneur;
import com.example.navire_backend.service.interfaces.IReceptionneur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionneurService implements IReceptionneur {
    @Override
    public Receptionneur saveReceptionneur(Receptionneur receptionneur) {
        return null;
    }

    @Override
    public Receptionneur updateReceptionneur(Receptionneur receptionneur) {
        return null;
    }

    @Override
    public boolean deleteReceptionneur(Long id) {
        return false;
    }

    @Override
    public List<Receptionneur> getListReceptionneur() {
        return null;
    }

    @Override
    public Receptionneur getReceptionneur(Long id) {
        return null;
    }

    @Override
    public Receptionneur findReceptionneurByName(String name) {
        return null;
    }

    @Override
    public int getQuantityOfReceptionneur() {
        return 0;
    }

    @Override
    public Receptionneur getReceptionneurByIdReceptionneur(Long id) {
        return null;
    }
}
