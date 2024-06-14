package com.movieseries.movieseries.service;

import com.movieseries.movieseries.dao.FavoriteRepository;
import com.movieseries.movieseries.dao.MovieRepository;
import com.movieseries.movieseries.dao.SeriesRepository;
import com.movieseries.movieseries.dao.UtilisateurRepository;
import com.movieseries.movieseries.dto.FavoriteDTO;
import com.movieseries.movieseries.dto.MovieDTO;
import com.movieseries.movieseries.model.Favorite;
import com.movieseries.movieseries.model.Movie;
import com.movieseries.movieseries.model.Series;
import com.movieseries.movieseries.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
private FavoriteRepository favoriteRepository;

    public List<FavoriteDTO> getAllFavorite() {
        return favoriteRepository.findAll().stream().map(favorite -> {
            FavoriteDTO dto = new FavoriteDTO();
            dto.setId_Favoris(favorite.getId_Favoris());
            if (favorite.getSeries() != null) {
                dto.setSeriesId(favorite.getSeries().getId_Series());
            }
            if (favorite.getMovie() != null) {
                dto.setMovieId(favorite.getMovie().getId_Movie());
            }
            return dto;
        }).collect(Collectors.toList());
    }
    public Optional<Favorite> getFavoriteById(Long id) {
        Optional<Favorite> favorite = favoriteRepository.findById(id);
       return favorite.map(m-> {
           Favorite favo = new Favorite();
           favo.setId_Favoris(m.getId_Favoris());
           favo.setSeries(m.getSeries());
           favo.setMovie(m.getMovie());
           favo.setUtilisateur(m.getUtilisateur());
        return favo;
       });
    }
    public List<Favorite> getFavoritesByIdUtilisateur(Long id) {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream()
            .filter(f -> f.getUtilisateur().getId_Utilisateur().equals(id))
            .map(f -> {
                Favorite favo = new Favorite();
                favo.setId_Favoris(f.getId_Favoris());
                favo.setSeries(f.getSeries());
                favo.setMovie(f.getMovie());
                favo.setUtilisateur(f.getUtilisateur());
                return favo;
            })
            .collect(Collectors.toList());
    }
    
    
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public FavoriteDTO addFavorite(FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();

        if (favoriteDTO.getMovieId() != null) {
            Movie movie = movieRepository.findById(favoriteDTO.getMovieId())
                    .orElseThrow(() -> new RuntimeException("Movie not found"));
            favorite.setMovie(movie);
        }

        if (favoriteDTO.getSeriesId() != null) {
            Series series = seriesRepository.findById(favoriteDTO.getSeriesId())
                    .orElseThrow(() -> new RuntimeException("Series not found"));
            favorite.setSeries(series);
        }

        if (favoriteDTO.getUtilisateurID() != null) {
            Utilisateur utilisateur = utilisateurRepository.findById(favoriteDTO.getUtilisateurID())
                    .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
            favorite.setUtilisateur(utilisateur);
        }        
        favorite = favoriteRepository.save(favorite);
        favoriteDTO.setId_Favoris(favorite.getId_Favoris());
        return favoriteDTO;
    }
    public void deleteUserById(Long id) {
        favoriteRepository.deleteById(id);
    }
}
