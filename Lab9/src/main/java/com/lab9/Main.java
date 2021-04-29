package com.lab9;

import com.lab9.manager.Chart;
import com.lab9.manager.ManagerEntity;
import com.lab9.repositories.GenresRepository;
import com.lab9.repositories.MoviesGenreRepository;
import com.lab9.repositories.MoviesRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = ManagerEntity.getEntity();
        EntityManager entityManager = factory.createEntityManager();
//        System.out.println(new GenresRepository(entityManager).findByName("Horror"));
//        System.out.println(new GenresRepository(entityManager).findByNameNamedQuery("Horror"));
//        Chart chart = new Chart(new MoviesRepository(entityManager),"asc");



    }
}
