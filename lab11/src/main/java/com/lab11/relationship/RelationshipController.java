package com.lab11.relationship;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/relationships")
public class RelationshipController {

    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService)
    {
        this.relationshipService=relationshipService;
    }

    @GetMapping
    public List<Relationship> getRelationships(){return relationshipService.getRelationships();}


    @PostMapping
    public void insertRelationship(@RequestBody Relationship relationship){ relationshipService.addNewRelationship(relationship);}

}
