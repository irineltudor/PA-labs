package com.lab8.dao;

import com.lab8.connection.connectToDB;
import com.lab8.interfaces.MovieDAO;
import com.lab8.objects.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    int id=0;
    static Connection conn
            = connectToDB.getConnection();
    @Override
    public void add(Movie movie) throws SQLException {
        String query
                = "insert into movies VALUES (?, ?, ?, ?)";
        PreparedStatement ps
                = conn.prepareStatement(query);
        ps.setInt(1,id);
        id++;
        ps.setString(2, movie.title);
        ps.setString(3, movie.release_date);
        ps.setDouble(4,movie.score);
        ps.executeUpdate();

    }

    @Override
    public void delete(int id){

    }

   @Override
    public Movie get(int id) throws SQLException {



        String query
                = "select * from movies where id= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, id);
        Movie movie= new Movie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            movie.setTitle(rs.getString("title"));
            movie.setRelease_date(rs.getString("release_date"));
            movie.setScore(rs.getDouble("score"));


        }

        if (check) {
            return movie;
        }
        else
            return null;
    }

    @Override
    public List<Movie> get(){
        return null;
    }

    @Override
    public void update(int id){

    }

    public int getId() {
        return id;
    }
}
