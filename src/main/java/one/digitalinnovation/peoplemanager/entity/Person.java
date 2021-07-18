package one.digitalinnovation.peoplemanager.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    //indexing with unique data is faster, also safe for certain data
    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    //Relation between table
    //FetchType Lazy improves performance
    //CascadeType for cascade additions, edits and removals
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
