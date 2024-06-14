package com.movieseries.movieseries.dto;

import com.movieseries.movieseries.model.Utilisateur;

import lombok.Data;

@Data
public class FavoriteDTO {
        private Long id_Favoris;
        private Long movieId;
        private Long seriesId;
        private Long utilisateurID;

}
