package io.zipcoder.crudapp.services;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService (PersonRepository repo){
        this.repository = repo;
    }

    public Person createPerson(Person p){
        return repository.save(p);
    }

    public Person getPerson(Integer id){
        return repository.findOne(id);
    }

    public Iterable<Person> getPersonList(){
        return repository.findAll();
    }

    public Person updatePerson(Integer id, Person p){
        Person originalP = repository.findOne(id);
        originalP.setFirstname(p.getFirstname());
        originalP.setLastname(p.getLastname());
        return repository.save(originalP);
    }

    public Boolean deletePerson(Integer id){
        repository.delete(id);
        return true;
    }
}
