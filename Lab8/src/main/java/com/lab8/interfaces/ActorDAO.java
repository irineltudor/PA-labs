package com.lab8.interfaces;

import com.lab8.objects.Actor;

import java.sql.SQLException;
import java.util.List;

public interface ActorDAO {

    void add(Actor actor)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Actor getActor(int id)
            throws SQLException;
    List<Actor> get(int movieId)
            throws SQLException;
    void update(int id)
            throws SQLException;
}
