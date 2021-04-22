package com.lab8.interfaces;

import com.lab8.objects.Director;

import java.sql.SQLException;
import java.util.List;

public interface DirectorDAO {
    void add(Director director)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Director getDirector(int id)
            throws SQLException;
    List<Director> get(int id)
            throws SQLException;
    void update(int id)
            throws SQLException;
}
