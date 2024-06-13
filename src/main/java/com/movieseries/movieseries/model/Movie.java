package com.movieseries.movieseries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Movie;
    private String titre;
    private String description;
    private String dateDeSortie;
    private Integer duree;
    private String genre;
    private String realisateur;
    private String acteurs;
    private Double note;
    private String cover;
}
