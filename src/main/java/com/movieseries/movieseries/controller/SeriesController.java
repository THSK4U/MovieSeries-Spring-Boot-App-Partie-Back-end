package com.movieseries.movieseries.controller;

import com.movieseries.movieseries.dto.MovieDTO;
import com.movieseries.movieseries.dto.SeriesDTO;
import com.movieseries.movieseries.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    @Autowired
    private SeriesService serieService;

    @GetMapping
    public ResponseEntity<List<SeriesDTO>> addSerie() {
        return ResponseEntity.ok( serieService.getAllSerie());
    }
    @PostMapping
    public ResponseEntity<SeriesDTO> addMovie(@RequestBody SeriesDTO SeriesDTO) {
        return ResponseEntity.ok(serieService.addSeries(SeriesDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Long id) {
        Optional<SeriesDTO> series = serieService.getSeriesById(id);
        return series.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/Delete?id={id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        serieService.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }
}
