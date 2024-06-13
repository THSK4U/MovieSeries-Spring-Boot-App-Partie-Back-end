package com.movieseries.movieseries.dto;

import lombok.Data;

@Data
public class SeriesDTO {
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
