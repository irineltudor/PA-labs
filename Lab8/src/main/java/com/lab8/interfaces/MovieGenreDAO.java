package com.lab8.interfaces;

import com.lab8.objects.Director;
import com.lab8.objects.MovieGenre;

import java.sql.SQLException;
import java.util.List;

public interface MovieGenreDAO {
    void add(MovieGenre movieGenre)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    MovieGenre get(int id)
            throws SQLException;
    List<MovieGenre> get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}
