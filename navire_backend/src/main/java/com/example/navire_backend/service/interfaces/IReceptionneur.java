package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Receptionneur;

import java.util.List;

public interface IReceptionneur {
    Receptionneur saveReceptionneur(Receptionneur receptionneur);

    Receptionneur updateReceptionneur(Receptionneur receptionneur);

    boolean deleteReceptionneur(Long id);

    List<Receptionneur> getListReceptionneur();

    Receptionneur getReceptionneur(Long id);

    Receptionneur findReceptionneurByName(String name);

    int getQuantityOfReceptionneur();

    Receptionneur getReceptionneurByIdReceptionneur(Long id);
}
