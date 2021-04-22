package com.lab8.objects;

public class Director {
    protected int movieId;
    protected String name;
   public Director()
   {

   }

    public Director(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                '}';
    }
}
