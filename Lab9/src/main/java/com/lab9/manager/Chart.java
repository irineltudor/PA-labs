package com.lab9.manager;

import com.lab9.entities.MoviesEntity;
import com.lab9.repositories.MoviesRepository;

import java.util.Collections;
import java.util.List;

public class Chart {
    List<MoviesEntity> movieList;
    public Chart(MoviesRepository movieRepository, String order)
    {
        movieList = movieRepository.findAll();
        if(order.equals("asc")){
            for(int i = 0; i < movieList.size() - 1; i++)
                for(int j = i; j < movieList.size(); j++)
                    if(movieList.get(i).getScore() < movieList.get(j).getScore())
                        Collections.swap(movieList, i, j);
        }
        else{
            for(int i = 0; i < movieList.size() - 1; i++)
                for(int j = i; j < movieList.size(); j++)
                    if(movieList.get(i).getScore() > movieList.get(j).getScore())
                        Collections.swap(movieList, i, j);
        }
        System.out.println("The list of films order by score " + order + ":");
        System.out.println();
        for(int i = 0; i < movieList.size(); i++)
        {
            System.out.println("Movie title: " + movieList.get(i).getTitle());
            System.out.println("Release Date: " + movieList.get(i).getReleaseDate());
            System.out.println("Rating: " + movieList.get(i).getScore());
            System.out.println();
        }
    }
}
