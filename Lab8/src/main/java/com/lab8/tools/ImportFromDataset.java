package com.lab8.tools;


import com.lab8.dao.*;
import com.lab8.objects.*;
import jxl.read.biff.BiffException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;


public class ImportFromDataset {

    MovieDAOImpl addMovie = new MovieDAOImpl();
    DirectorDAOImpl addDirector = new DirectorDAOImpl();
    ActorDAOImpl addActor = new ActorDAOImpl();
    GenreDAOImpl addGenre = new GenreDAOImpl();
    MovieGenreDAOImpl addMovieGenre = new MovieGenreDAOImpl();

    private void ImportAllMovieGenres(String fileName) throws IOException, SQLException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String row;
        row = csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split("\\|");
            String[] genres=data[5].split(",");
            for (String genre:genres
            ) { genre=genre.replace(" ","");
                addGenre.add(new Genre(genre));

            }


            // do something with the data
        }
        System.out.println("gata");
        csvReader.close();
    }



    public ImportFromDataset(String fileName) throws IOException, SQLException, BiffException {
//        ImportAllMovieGenres(fileName);
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String row;
        row = csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {
            String[] data=row.split("\\|");
            Movie movie=new Movie(data[1],data[4],Double.parseDouble(data[14]));
            addMovie.add(movie);
            String[] actors=data[12].split(",");
            for (String actor:actors
                 ) {

                Actor newActor=new Actor(addMovie.getId()-1,actor);
                addActor.add(newActor);

            }
            String[] directors=data[9].split(",");
            for (String director:directors
            ) {
                Director newDirector=new Director(addMovie.getId()-1,director);
                addDirector.add(newDirector);

            }
            String[] genres=data[5].split(",");
            for (String genre:genres
            ) { genre=genre.replace(" ","");
                addMovieGenre.add(new MovieGenre(addMovie.getId()-1,addGenre.get(genre)));

            }


        }
        csvReader.close();

    }
}
