package com.lab9.dao;

import com.lab9.entities.MovieActorsEntity;

import java.sql.SQLException;
import java.util.List;

public interface ActorDAO {

    void add(MovieActorsEntity actor)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    MovieActorsEntity getActor(int id)
            throws SQLException;
    List<MovieActorsEntity> get(int movieId)
            throws SQLException;
    void update(int id)
            throws SQLException;
}
