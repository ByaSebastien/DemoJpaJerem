package be.btorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Table(name = "CUSTOMER",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_blabla",
                          columnNames = {"FIRST_NAME","LAST_NAME"})
    })
@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME",length = 50,nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME",length = 50,nullable = false)
    private String lastName;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Embedded
    private Address address;

    @OrderColumn(name = "index")
    @ElementCollection
    private List<String> friends;
    public User(String firstName, String lastName, LocalDate birthDate, GenderType gender, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }
}
