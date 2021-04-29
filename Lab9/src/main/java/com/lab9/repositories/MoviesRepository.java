package com.lab9.repositories;

import com.lab9.entities.MoviesEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class MoviesRepository {

    private final EntityManager entityManager;

    public MoviesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public MoviesEntity findById(Integer id) {
        MoviesEntity moviesEntity = entityManager.find(MoviesEntity.class, id);
        return moviesEntity;
    }


    public List<MoviesEntity> findAll() {
        return entityManager.createQuery("from MoviesEntity").getResultList();
    }
    public MoviesEntity findByTitle(String name) {
        MoviesEntity moviesEntity= entityManager.createQuery("SELECT g FROM MoviesEntity g WHERE g.title = :name", MoviesEntity.class)
                .setParameter("name", name)
                .getSingleResult();
        return moviesEntity;
    }
    public Optional<MoviesEntity> save(MoviesEntity moviesEntity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(moviesEntity);
            entityManager.getTransaction().commit();
            return Optional.of(moviesEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
