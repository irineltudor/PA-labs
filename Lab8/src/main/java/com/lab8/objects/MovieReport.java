package com.lab8.objects;
import com.lab8.dao.*;

import java.sql.SQLException;
import java.util.List;
public class MovieReport {

    public String name = "marcel";
    public String movie_title;
    public String movie_genre;
    public String movie_release_date;
    public double movie_score;
    public List<Director> directors;
    public List<Actor> actors;

    protected int id;
    public MovieReport(int id) throws SQLException {
        this.id = id;
        Movie movie = new MovieDAOImpl().get(id);
        movie_title = movie.title;
        movie_release_date = movie.release_date;
        movie_score = movie.score;
        directors = new DirectorDAOImpl().get(id);
        actors = new ActorDAOImpl().get(id);
        Genre genre = new GenreDAOImpl().get(new MovieGenreDAOImpl().get(id).getGenreId());
        movie_genre = genre.name;
    }

    public String getName() {
        return name;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public double getMovie_score() {
        return movie_score;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovieReport{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_genre='" + movie_genre + '\'' +
                ", movie_release_date='" + movie_release_date + '\'' +
                ", movie_score=" + movie_score +
                ", directors=" + directors +
                ", actors=" + actors +
                ", id=" + id +
                '}';
    }
}
