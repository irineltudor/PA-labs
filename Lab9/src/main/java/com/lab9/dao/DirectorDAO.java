package com.lab9.dao;

import com.lab9.entities.MovieDirectorsEntity;

import java.sql.SQLException;
import java.util.List;

public interface DirectorDAO {
    void add(MovieDirectorsEntity director)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    MovieDirectorsEntity getDirector(int id)
            throws SQLException;
    List<MovieDirectorsEntity> get(int id)
            throws SQLException;
    void update(int id)
            throws SQLException;
}