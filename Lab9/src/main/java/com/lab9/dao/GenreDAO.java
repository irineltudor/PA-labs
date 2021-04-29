package com.lab9.dao;

import com.lab9.entities.GenresEntity;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {

    void add(GenresEntity genre)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    GenresEntity get(int id)
            throws SQLException;
    List<GenresEntity> get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}