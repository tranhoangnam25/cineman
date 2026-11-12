package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tblMovie1")
public class Movie1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movieName", length = 200)
    private String movieName;

    @Column(name = "genre", length = 100)
    private String genre;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "actors", length = 300)
    private String actors;

    @Column(name = "duration")
    private int duration;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "status", length = 20)
    private String status;

    public Movie1() {
    }

    public Movie1(String movieName, String genre, String director, String actors, int duration,
                  LocalDate releaseDate, String description, String status) {
        this.movieName = movieName;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
