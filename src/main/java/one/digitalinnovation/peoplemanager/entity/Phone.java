package one.digitalinnovation.peoplemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.peoplemanager.enums.PhoneType;

import javax.persistence.*;

//Annotations for DB Entity:
@Entity
//Annotations for Getters and Setters
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    //More DB Configs through annotations:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String numer;
}
