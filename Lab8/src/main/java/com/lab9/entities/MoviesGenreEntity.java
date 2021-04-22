package com.lab9.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movies_genre", schema = "lab8java")
public class MoviesGenreEntity {
    private int id;
    private Integer movieId;
    private Integer genreId;
    private MoviesEntity moviesByMovieId;
    private GenresEntity genresByGenreId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movieId", nullable = true)
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "genreId", nullable = true)
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesGenreEntity that = (MoviesGenreEntity) o;
        return id == that.id && Objects.equals(movieId, that.movieId) && Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, genreId);
    }

    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id")
    public MoviesEntity getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(MoviesEntity moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    @ManyToOne
    @JoinColumn(name = "genreId", referencedColumnName = "id")
    public GenresEntity getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(GenresEntity genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }
}
