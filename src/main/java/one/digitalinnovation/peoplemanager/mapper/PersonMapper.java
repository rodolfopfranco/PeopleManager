package one.digitalinnovation.peoplemanager.mapper;

import one.digitalinnovation.peoplemanager.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanager.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    //Transforms received DTO into model object
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Transforms String to Date
    @Mapping(target = "birthDate", source="birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
