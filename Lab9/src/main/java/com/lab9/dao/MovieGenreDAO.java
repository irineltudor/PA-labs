package com.lab9.dao;

import com.lab9.entities.MoviesGenreEntity ;

import java.sql.SQLException;
import java.util.List;

public interface MovieGenreDAO {
    void add(MoviesGenreEntity  movieGenre)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    MoviesGenreEntity  get(int id)
            throws SQLException;
    List<MoviesGenreEntity > get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}
