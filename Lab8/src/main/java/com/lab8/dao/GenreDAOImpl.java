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
                = "select * from genres where name = ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setString(1, genre.name);
        ResultSet rs = ps.executeQuery();
        boolean check = true;
        while (rs.next()) {
            check = false;
        }

        if(check) {
            String query1
                    = "insert into genres VALUES (?, ?)";
            PreparedStatement ps1
                    = conn.prepareStatement(query1);
            ps1.setInt(1, id);
            id++;
            ps1.setString(2, genre.name);
            ps1.executeUpdate();
        }


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

    public int get(String name) throws SQLException {
        String query
                = "select * from genres where name = ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setString(1, name);
        Genre genre = new Genre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        int id=-1;

        while (rs.next()) {
            check = true;
            id=rs.getInt("id");

        }

        if (check) {
            return id;
        }
        else
            return -1;
    }

    @Override
    public List<Genre> get(){
        return null;
    }

    @Override
    public void update(int id){

    }
}
