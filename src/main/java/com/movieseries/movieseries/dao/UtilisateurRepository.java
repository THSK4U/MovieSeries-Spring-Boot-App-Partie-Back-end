package com.movieseries.movieseries.dao;

import com.movieseries.movieseries.model.Series;
import com.movieseries.movieseries.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
