package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping("/people/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.createPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(service.getPersonList(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Integer id, Person p){
        return new ResponseEntity<>(service.updatePerson(id, p), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.NO_CONTENT);
    }
}
