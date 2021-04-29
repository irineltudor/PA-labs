package com.lab9.repositories;


import com.lab9.entities.GenresEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class GenresRepository {
    private final EntityManager entityManager;
    public GenresRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public GenresEntity findById(Integer id) {
        GenresEntity genresEntity = entityManager.find(GenresEntity.class, id);
        return genresEntity;
    }

    public List<GenresEntity> findAll() {
        return entityManager.createQuery("from GenresEntity").getResultList();
    }

    public GenresEntity findByNameNamedQuery(String name) {
        GenresEntity genresEntity= entityManager.createNamedQuery(GenresEntity.QUERY_FIND_BY_NAME, GenresEntity.class)
                .setParameter("name", name)
                .getSingleResult();
        return genresEntity;
    }


        public GenresEntity findByName(String name) {
        GenresEntity genresEntity= entityManager.createQuery("SELECT g FROM GenresEntity g WHERE g.name = :name", GenresEntity.class)
                .setParameter("name", name)
                .getSingleResult();
        return genresEntity;
    }
    public Optional<GenresEntity> save(GenresEntity genresEntity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(genresEntity);
            entityManager.getTransaction().commit();
            return Optional.of(genresEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
