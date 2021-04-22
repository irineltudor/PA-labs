package com.lab8.objects;

import com.lab8.dao.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MovieInformation {
    protected int id;
    public MovieInformation(int id){
        this.id = id;
    }

    private Movie getMovie() throws SQLException{
        return new MovieDAOImpl().get(id);
    }

    private List<Actor> getMovieActors() throws SQLException {

         return new ActorDAOImpl().get(id);
    }


    private List<Director> getMovieDirectors() throws SQLException {

        return new DirectorDAOImpl().get(id);
    }

    private Genre getMovieGenre() throws SQLException {
        return new GenreDAOImpl().get(new MovieGenreDAOImpl().get(id).getGenreId());
    }

    public void printInformation() throws SQLException {
        System.out.println(getMovie());
        System.out.println(getMovieActors());
        System.out.println(getMovieDirectors());
        System.out.println(getMovieGenre());
    }
}
