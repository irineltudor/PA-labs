package com.lab9.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_actors", schema = "lab8java")
public class MovieActorsEntity {
    private int id;
    private String name;
    private Integer movieId;
    private MoviesEntity moviesByMovieId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "movieId", nullable = true)
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActorsEntity that = (MovieActorsEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movieId);
    }

    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id")
    public MoviesEntity getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(MoviesEntity moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }
}
