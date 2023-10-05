package be.btorm.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class Mayor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "mayor")
    private Municipality municipality;
}
