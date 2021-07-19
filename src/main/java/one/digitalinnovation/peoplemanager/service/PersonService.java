package one.digitalinnovation.peoplemanager.service;

import one.digitalinnovation.peoplemanager.dto.MessageResponseDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import one.digitalinnovation.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    //Repository is applied on constructor
    //Easy future mock JUnits Tests
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        //Message on 200 success code:
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }
}