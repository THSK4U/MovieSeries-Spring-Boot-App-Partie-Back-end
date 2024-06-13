package com.movieseries.movieseries.service;

import com.movieseries.movieseries.dao.FavoriteRepository;
import com.movieseries.movieseries.dto.FavoriteDTO;
import com.movieseries.movieseries.model.Favorite;
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
        return favo;
       });
    }
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

}
