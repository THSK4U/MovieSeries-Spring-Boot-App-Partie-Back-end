package com.movieseries.movieseries.service;

import com.movieseries.movieseries.dto.UtilisateurDTO;
import com.movieseries.movieseries.model.Utilisateur;
import com.movieseries.movieseries.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public UtilisateurDTO saveUser(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPassword(utilisateurDTO.getPassword());
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurDTO;
    }

    public void deleteUserById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
