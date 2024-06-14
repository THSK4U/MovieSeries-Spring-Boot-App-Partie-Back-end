package com.movieseries.movieseries.service;

import com.movieseries.movieseries.dao.SeriesRepository;
import com.movieseries.movieseries.dto.MovieDTO;
import com.movieseries.movieseries.dto.SeriesDTO;
import com.movieseries.movieseries.model.Movie;
import com.movieseries.movieseries.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public List<SeriesDTO> getAllSerie() {
        return seriesRepository.findAll().stream().map(series -> {
            SeriesDTO dto = new SeriesDTO();
            dto.setId_Series(series.getId_Series());
            dto.setTitre(series.getTitre());
            dto.setDescription(series.getDescription());
            dto.setDateDebut(series.getDateDebut());
            dto.setDateFin(series.getDateFin());
            dto.setGenre(series.getGenre());
            dto.setActeurs(series.getActeurs());
            dto.setNombreSaisons(series.getNombreSaisons());
            dto.setNote(series.getNote());
            dto.setGenre(series.getGenre());
            return dto;
        }).collect(Collectors.toList());
    }

    public SeriesDTO addSeries(SeriesDTO seriesDTO) {
        Series series = new Series();
        series.setTitre(seriesDTO.getTitre());
        series.setDescription(seriesDTO.getDescription());
        series.setDateDebut(seriesDTO.getDateDebut());
        series.setDateFin(seriesDTO.getDateFin());
        series.setGenre(seriesDTO.getGenre());
        series.setActeurs(seriesDTO.getActeurs());
        series.setNombreSaisons(seriesDTO.getNombreSaisons());
        series.setNote(seriesDTO.getNote());
        series = seriesRepository.save(series);
        return seriesDTO;
    }
    public Optional<SeriesDTO> getSeriesById(Long id) {
        Optional<Series> series = seriesRepository.findById(id);
        return series.map(s -> {
            SeriesDTO dto = new SeriesDTO();
            dto.setId_Series(s.getId_Series());
            dto.setTitre(s.getTitre());
            dto.setDescription(s.getDescription());
            dto.setDateDebut(s.getDateDebut());
            dto.setDateFin(s.getDateFin());
            dto.setGenre(s.getGenre());
            dto.setActeurs(s.getActeurs());
            dto.setNombreSaisons(s.getNombreSaisons());
            dto.setNote(s.getNote());
            return dto;
        });
    }

    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }
}