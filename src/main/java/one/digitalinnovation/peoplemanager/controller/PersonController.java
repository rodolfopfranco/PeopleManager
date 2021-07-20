package one.digitalinnovation.peoplemanager.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.peoplemanager.dto.MessageResponseDTO;
import one.digitalinnovation.peoplemanager.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import one.digitalinnovation.peoplemanager.exception.PersonNotFoundException;
import one.digitalinnovation.peoplemanager.repository.PersonRepository;
import one.digitalinnovation.peoplemanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Defines the callable http address for this object:
@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
/*
replaces the constructor:
@Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
 */
public class PersonController {

    private PersonService personService;

    @PostMapping
    //RequestBody tells the content comes from the request
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    //Returns a list with every person:
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    //To enable another get, defines a kind of PHP-like GET.
    @GetMapping("/{id}")
    public PersonDTO findByID(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById
            (@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }
}