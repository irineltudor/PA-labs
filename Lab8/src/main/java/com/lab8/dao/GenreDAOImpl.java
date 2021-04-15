package com.lab8.dao;

import com.lab8.connection.connectToDB;
import com.lab8.interfaces.GenreDAO;
import com.lab8.objects.Genre;

import java.sql.*;
import java.util.List;

public class GenreDAOImpl implements GenreDAO {
    int id=0;
    static Connection conn
            = connectToDB.getConnection();

    @Override
    public void add(Genre genre) throws SQLException {

        String query
                = "insert into genres VALUES (?, ?)";
        PreparedStatement ps
                = conn.prepareStatement(query);
        ps.setInt(1,id);
        id++;
        ps.setString(2, genre.name);
        ps.executeUpdate();


    }

    @Override
    public void delete(int id){

    }

    public Genre get(int id) throws SQLException {
        String query
                = "select * from genres where id= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, id);
        Genre genre = new Genre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            genre.setName(rs.getString("name"));

        }

        if (check) {
            return genre;
        }
        else
            return null;
    }

    @Override
    public List<Genre> get(){
        return null;
    }

    @Override
    public void update(int id){

    }
}
