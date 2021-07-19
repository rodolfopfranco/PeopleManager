package one.digitalinnovation.peoplemanager.controller;

import one.digitalinnovation.peoplemanager.dto.MessageResponseDTO;
import one.digitalinnovation.peoplemanager.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import one.digitalinnovation.peoplemanager.repository.PersonRepository;
import one.digitalinnovation.peoplemanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Defines the callable http address for this object:
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    //RequestBody tells the content comes from the request
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }
}