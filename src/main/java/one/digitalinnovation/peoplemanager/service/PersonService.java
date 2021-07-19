package one.digitalinnovation.peoplemanager.service;

import one.digitalinnovation.peoplemanager.dto.MessageResponseDTO;
import one.digitalinnovation.peoplemanager.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import one.digitalinnovation.peoplemanager.mapper.PersonMapper;
import one.digitalinnovation.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    //Repository is applied on constructor
    //Easy future mock JUnits Tests
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        //Message on 200 success code:
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        //Trabsforms to DTO and adds to a list via Stream
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}