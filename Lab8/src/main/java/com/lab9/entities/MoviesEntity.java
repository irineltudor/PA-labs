package com.lab9.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "lab8java")
public class MoviesEntity {
    private int id;
    private String title;
    private String releaseDate;
    private Integer score;
    private Collection<MovieActorsEntity> movieActorsById;
    private Collection<MovieDirectorsEntity> movieDirectorsById;
    private Collection<MoviesGenreEntity> moviesGenresById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "release_date", nullable = true, length = 255)
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, score);
    }

    @OneToMany(mappedBy = "moviesByMovieId")
    public Collection<MovieActorsEntity> getMovieActorsById() {
        return movieActorsById;
    }

    public void setMovieActorsById(Collection<MovieActorsEntity> movieActorsById) {
        this.movieActorsById = movieActorsById;
    }

    @OneToMany(mappedBy = "moviesByMovieId")
    public Collection<MovieDirectorsEntity> getMovieDirectorsById() {
        return movieDirectorsById;
    }

    public void setMovieDirectorsById(Collection<MovieDirectorsEntity> movieDirectorsById) {
        this.movieDirectorsById = movieDirectorsById;
    }

    @OneToMany(mappedBy = "moviesByMovieId")
    public Collection<MoviesGenreEntity> getMoviesGenresById() {
        return moviesGenresById;
    }

    public void setMoviesGenresById(Collection<MoviesGenreEntity> moviesGenresById) {
        this.moviesGenresById = moviesGenresById;
    }
}
