package com.lab8.objects;

public class Actor {
        protected int movieId;
        protected String name;


        public Actor()
        {

        }

        public Actor(int movieId, String name) {
                this.movieId = movieId;
                this.name=name;
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
                return "Actor{" +
                        "movieId=" + movieId +
                        ", name='" + name + '\'' +
                        '}';
        }
}
