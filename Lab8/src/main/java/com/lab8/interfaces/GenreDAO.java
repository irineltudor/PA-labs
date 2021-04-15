package com.lab8.interfaces;

import com.lab8.objects.Genre;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {

    void add(Genre genre)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Genre get(int id)
            throws SQLException;
    List<Genre> get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}
