package com.lab8.dao;

import com.lab8.connection.connectToDB;
import com.lab8.interfaces.MovieGenreDAO;
import com.lab8.objects.MovieGenre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieGenreDAOImpl implements MovieGenreDAO {
    int id=0;
    static Connection conn
            = connectToDB.getConnection();
    @Override
    public void add(MovieGenre movieGenre) throws SQLException {
        String query
                = "insert into movies_genre VALUES (?, ?, ?)";
        PreparedStatement ps
                = conn.prepareStatement(query);
        ps.setInt(1,id);
        id++;
        ps.setInt(2, movieGenre.getMovieId());
        ps.setInt(3, movieGenre.getGenreId());
        ps.executeUpdate();

    }

    @Override
    public void delete(int id){

    }

    @Override
    public MovieGenre get(int id) throws SQLException {



        String query
                = "select * from movies_genre where movieId= ?";
        PreparedStatement ps
                = conn.prepareStatement(query);

        ps.setInt(1, id);
        MovieGenre movieGenre= new MovieGenre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            movieGenre.setMovieId(rs.getInt("movieId"));
            movieGenre.setGenreId(rs.getInt("genreId"));


        }

        if (check) {
            return movieGenre;
        }
        else
            return null;
    }

    @Override
    public List<MovieGenre> get(){
        return null;
    }

    @Override
    public void update(int id){

    }
}
