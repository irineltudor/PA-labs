package com.lab8.dao;

import com.lab8.connection.connectToDB;
import com.lab8.interfaces.DirectorDAO;
import com.lab8.objects.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DirectorDAOImpl implements DirectorDAO {
    int id=0;
    static Connection conn
            = connectToDB.getConnection();

    @Override
    public void add(Director director) throws SQLException {
        String query
                = "insert into movie_directors VALUES (?, ?, ?)";
        PreparedStatement ps
                = conn.prepareStatement(query);
        ps.setInt(1,id);
        id++;
        ps.setString(2, director.getName());
        ps.setInt(3,director.getMovieId());
        ps.executeUpdate();

    }

    @Override
    public void delete(int id){

    }

    @Override
    public Director getDirector(int id) throws SQLException {



        String query
                = "select * from movie_directors where id= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, id);
        Director director= new Director();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            director.setName(rs.getString("name"));
            director.setMovieId(rs.getInt("movieId"));


        }

        if (check) {
            return director;
        }
        else
            return null;
    }

    @Override
    public List<Director> get(int movieId) throws SQLException {



        String query
                = "select * from movie_directors where movieId= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, movieId);
        List<Director> directors=new LinkedList<>();

        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            Director director= new Director();
            director.setName(rs.getString("name"));
            director.setMovieId(rs.getInt("movieId"));
            directors.add(director);


        }

        if (check) {
            return directors;
        }
        else
            return null;
    }

    @Override
    public void update(int id){

    }

}
