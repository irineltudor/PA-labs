package com.lab9.dao;

import com.lab9.entities.MoviesEntity;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO{
    void add(MoviesEntity movie)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    MoviesEntity get(int id)
            throws SQLException;
    List<MoviesEntity> get()
            throws SQLException;
    void update(int id)
            throws SQLException;
}