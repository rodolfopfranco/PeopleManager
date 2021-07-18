package one.digitalinnovation.peoplemanager.controller;

import one.digitalinnovation.peoplemanager.dto.MessageResponseDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import one.digitalinnovation.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Defines the callable http address for this object:
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    //Repository is applied on constructor
    //Easy future mock JUnits Tests
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    //RequestBody tells the content comes from the request
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID"+savedPerson.getId())
                .build();
    }
}