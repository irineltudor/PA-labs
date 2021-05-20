package com.lab11.relationship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship,Long>
{

    @Query("SELECT r FROM Relationship r WHERE (r.person1_id=?1 and r.person2_id=?2 ) OR (r.person2_id=?1 and r.person1_id=?2)")
    Optional<Relationship> findRelationship(Long person1_id, Long person2_id);


}
