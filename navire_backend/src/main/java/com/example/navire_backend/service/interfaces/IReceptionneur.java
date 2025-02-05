package com.example.navire_backend.service.interfaces;

import com.example.navire_backend.persistence.DTO.ReceptionneurDTO;
import com.example.navire_backend.persistence.entities.Receptionneur;

import java.util.List;

public interface IReceptionneur {
    Receptionneur saveReceptionneur(Receptionneur receptionneur);

    Receptionneur updateReceptionneur(int id,Receptionneur receptionneur);

    void deleteReceptionneur(int id);

    List<ReceptionneurDTO> getListReceptionneur();

    ReceptionneurDTO getReceptionneurById(int id);

    List<ReceptionneurDTO> findReceptionneurByName(String name);

    List<ReceptionneurDTO> getReceptionneurByPrenomNom(String prenom, String nom);

    int getQuantityOfReceptionneur();




}
