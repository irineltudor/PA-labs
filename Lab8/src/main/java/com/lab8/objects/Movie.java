package com.lab8.objects;

public class Movie {

    public String title;
    public String release_date;
    public double score;

    public Movie() {

    }

    public Movie(String title, String release_date, double score) {
        this.title = title;
        this.release_date = release_date;
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Movie(String title, String release_date, int score) {
        this.title = title;
        this.release_date = release_date;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", score=" + score +
                '}';
    }
}
