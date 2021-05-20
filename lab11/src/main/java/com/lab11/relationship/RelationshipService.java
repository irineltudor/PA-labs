package com.lab11.relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;

    @Autowired
    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }


    public List<Relationship> getRelationships(){
        return relationshipRepository.findAll();
    }

    public void addNewRelationship(Relationship relationship) {
        Optional<Relationship> friendshipOptional= relationshipRepository.findRelationship(relationship.getPerson1_id(),relationship.getPerson2_id());
        if(friendshipOptional.isPresent())
        {
            throw new IllegalStateException("friendship already added");
        }

        relationshipRepository.save(relationship);
    }

}
