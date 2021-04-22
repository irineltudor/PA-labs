package com.lab9.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "genres", schema = "lab8java")
public class GenresEntity {
    private int id;
    private String name;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresEntity that = (GenresEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "genresByGenreId")
    public Collection<MoviesGenreEntity> getMoviesGenresById() {
        return moviesGenresById;
    }

    public void setMoviesGenresById(Collection<MoviesGenreEntity> moviesGenresById) {
        this.moviesGenresById = moviesGenresById;
    }
}
