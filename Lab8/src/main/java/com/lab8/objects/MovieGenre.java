package com.lab8.objects;


public class MovieGenre {
    protected int movieId;
    protected int genreId;

    public MovieGenre()
    {

    }
    public MovieGenre(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "MovieGenre{" +
                "movieId=" + movieId +
                ", genreId=" + genreId +
                '}';
    }
}
