package com.movieseries.movieseries.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private Long id_Utilisateur;
    private String email;
    private String nom;
    private String password;
}
