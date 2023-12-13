package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.entities.Receptionneur;

import java.util.List;

public interface IReceptionneur {
    Receptionneur saveReceptionneur(Receptionneur receptionneur);

    Receptionneur updateReceptionneur(int id,Receptionneur receptionneur);

    void deleteReceptionneur(int id);

    List<Receptionneur> getListReceptionneur();

    Receptionneur getReceptionneurById(int id);

    List<Receptionneur> findReceptionneurByName(String name);

    List<Receptionneur> getReceptionneurByPrenomNom(String prenom, String nom);

    int getQuantityOfReceptionneur();




}
