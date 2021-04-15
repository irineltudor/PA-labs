package com.lab8;


import com.lab8.dao.GenreDAOImpl;
import com.lab8.dao.MovieDAOImpl;
import com.lab8.objects.Genre;
import com.lab8.objects.Movie;


import java.sql.SQLException;

public class AddInformationsToTable {

    AddInformationsToTable() throws SQLException {
        GenreDAOImpl genre=new GenreDAOImpl();
        genre.add(new Genre("Drama"));
        genre.add(new Genre("Comedy"));
        genre.add(new Genre("Horror"));

        MovieDAOImpl movies=new MovieDAOImpl();
        movies.add(new Movie("Black Panther","2018",520));
        movies.add(new Movie("Us","2019",547));
        movies.add(new Movie("It Happened One Night","1934",96));
    }
}
