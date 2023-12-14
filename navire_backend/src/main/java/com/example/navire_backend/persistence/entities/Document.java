package com.example.navire_backend.persistence.entities;

import com.example.navire_backend.persistence.DTO.DocumentDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    @ManyToOne
    @JoinColumn(name = "navire_id")
    @JsonBackReference
    private Navire navire;

    public DocumentDTO toDTO() {
        boolean boolNavire= navire!=null;
        return new DocumentDTO(id, type, boolNavire ? navire.getId() : 0,boolNavire?navire.getNom():"");
    }
}
