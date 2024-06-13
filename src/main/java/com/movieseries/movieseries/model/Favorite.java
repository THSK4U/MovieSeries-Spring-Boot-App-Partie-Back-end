package com.movieseries.movieseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Favoris")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Favoris;

    @ManyToOne
    @JoinColumn(name = "id_Movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_Series")
    private Series series;
    }
