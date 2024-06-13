package com.movieseries.movieseries.dto;

import lombok.Data;

@Data
public class MovieDTO {
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
