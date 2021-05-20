package com.lab11.person;

import com.lab11.exception.InvalidFieldException;


import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons()
    {
        return personService.getPersons();
    }

    @RequestMapping("/popular/{k}")
    public List<Person> getMostPopular(@PathVariable("k") int k)
    {
        return personService.getMostPopular(k);
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) throws InvalidFieldException {
        if(StringUtils.isBlank(person.getName())){
            throw new InvalidFieldException("Name is a required field");
        }
        if(StringUtils.isBlank(person.getEmail())){
            throw new InvalidFieldException("Email is a required field");
        }
        if(StringUtils.isBlank(String.valueOf(person.getDob()))){
            throw new InvalidFieldException("Dob is a required field");
        }

        personService.addNewPerson(person);
    }

    @DeleteMapping(path="{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) throws InvalidFieldException {
        if(StringUtils.isBlank(name)){
            throw new InvalidFieldException("Name is a required field");
        }
        if(StringUtils.isBlank(email)){
            throw new InvalidFieldException("Email is a required field");
        }

       personService.updateStudent(personId, name, email);
    }

}
