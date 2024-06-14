package com.movieseries.movieseries.controller;


import com.movieseries.movieseries.dto.FavoriteDTO;
import com.movieseries.movieseries.dto.SeriesDTO;
import com.movieseries.movieseries.model.Favorite;
import com.movieseries.movieseries.service.FavoriteService;
import com.movieseries.movieseries.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllMovies() {
        return ResponseEntity.ok(favoriteService.getAllFavorite());
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Favorite>> getUserById(@PathVariable Long id) {
        List<Favorite> favorites = favoriteService.getFavoritesByIdUtilisateur(id);
        if (favorites.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(favorites);
        }
    }
    
    @PostMapping
    public ResponseEntity<FavoriteDTO> addMovie(@RequestBody FavoriteDTO favoriteDTO) {
        return ResponseEntity.ok(favoriteService.addFavorite(favoriteDTO));
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        favoriteService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
