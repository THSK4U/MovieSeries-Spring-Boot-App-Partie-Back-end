package com.movieseries.movieseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Series;
    private String titre;
    private String description;
    private String dateDebut;
    private String dateFin;
    private Integer nombreSaisons;
    private String genre;
    private String createur;
    private String acteurs;
    private Double note;
}
