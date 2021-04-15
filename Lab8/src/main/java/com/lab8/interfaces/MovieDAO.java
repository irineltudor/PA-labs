package com.lab8.interfaces;

import com.lab8.objects.Genre;
import com.lab8.objects.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO{
    void add(Movie movie)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Movie get(int id)
            throws SQLException;
    List<Movie> get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}
