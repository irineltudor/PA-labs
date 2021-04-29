package com.lab9;

import com.lab9.manager.ManagerEntity;
import com.lab9.repositories.GenresRepository;
import org.apache.log4j.BasicConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = ManagerEntity.getEntity();
        EntityManager entityManager = factory.createEntityManager();
        System.out.println(new GenresRepository(entityManager).findByName("Horror"));

    }
}
