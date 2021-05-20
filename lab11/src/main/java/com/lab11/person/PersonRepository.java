package com.lab11.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.email = ?1")
    Optional<Person> findPersonByEmail(String email);

    @Query("SELECT p from Person p, Relationship r WHERE r.person1_id=p.id or r.person2_id=p.id GROUP BY p ORDER BY count(r.id) desc")
    List<Person> getMostPopular();
}
