package com.lab9.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movies_genre", schema = "lab8java", catalog = "")
public class MoviesGenreEntity {
    private int id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesGenreEntity that = (MoviesGenreEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
