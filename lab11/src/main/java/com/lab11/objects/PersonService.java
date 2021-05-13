package com.lab11.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons()
    {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {

        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if(personOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }

        personRepository.save(person);
    }

    public void deletePerson(Long personId) {

        if(!personRepository.existsById(personId))
        {
            throw new IllegalStateException("student with id " + personId + " does not exists");
        }

        personRepository.deleteById(personId);
    }

    @Transactional
    public void updateStudent(Long personId, String name,String email){

        Person person=personRepository.findById(personId).orElseThrow(() -> new IllegalStateException("Student with id " + personId + " does not exists"));

        if( name !=null && name.length()>0 && !Objects.equals(person.getName(),name))
        {
            person.setName(name);
        }

        if( email !=null && email.length()>0 && !Objects.equals(person.getEmail(),email))
        {
            Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
            if(personOptional.isPresent())
            {
                throw new IllegalStateException("email taken");
            }

            person.setEmail(email);
        }



    }
}
