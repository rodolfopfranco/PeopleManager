package one.digitalinnovation.peoplemanager.repository;

import one.digitalinnovation.peoplemanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//extendends the DB object with PK type on the Generics
public interface PersonRepository extends JpaRepository<Person, Long> {
}
