package com.movieseries.movieseries.service;

import com.movieseries.movieseries.dto.MovieDTO;
import com.movieseries.movieseries.model.Movie;
import com.movieseries.movieseries.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setId_Movie(movie.getId_Movie());
            dto.setTitre(movie.getTitre());
            dto.setGenre(movie.getGenre());
            dto.setDateDeSortie(movie.getDateDeSortie());
            dto.setActeurs(movie.getActeurs());
            dto.setDescription(movie.getDescription());
            dto.setCover(movie.getCover());
            dto.setDuree(movie.getDuree());
            dto.setNote(movie.getNote());
            dto.setRealisateur(movie.getRealisateur());
            return dto;
        }).collect(Collectors.toList());
    }

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitre(movieDTO.getTitre());
        movie.setGenre(movieDTO.getGenre());
        movie.setDateDeSortie(movieDTO.getDateDeSortie());
        movie.setActeurs(movieDTO.getActeurs());
        movie.setDescription(movieDTO.getDescription());
        movie.setCover(movieDTO.getCover());
        movie.setNote(movieDTO.getNote());
        movie.setDuree(movieDTO.getDuree());
        movie.setRealisateur(movieDTO.getRealisateur());
        movie = movieRepository.save(movie);
        return movieDTO;
    }
    public Optional<MovieDTO> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(m -> {
            MovieDTO dto = new MovieDTO();
            dto.setId_Movie(m.getId_Movie());
            dto.setTitre(m.getTitre());
            dto.setGenre(m.getGenre());
            dto.setDateDeSortie(m.getDateDeSortie());
            dto.setActeurs(m.getActeurs());
            dto.setDescription(m.getDescription());
            dto.setCover(m.getCover());
            dto.setDuree(m.getDuree());
            dto.setNote(m.getNote());
            dto.setRealisateur(m.getRealisateur());
            return dto;
        });
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
