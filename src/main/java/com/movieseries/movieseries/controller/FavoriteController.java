package com.movieseries.movieseries.controller;


import com.movieseries.movieseries.dto.FavoriteDTO;
import com.movieseries.movieseries.service.FavoriteService;
import com.movieseries.movieseries.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllMovies() {
        return ResponseEntity.ok(favoriteService.getAllFavorite());
    }


}
