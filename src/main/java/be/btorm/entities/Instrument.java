package be.btorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @ManyToMany(mappedBy = "instruments",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<Musician> musicians;

    public Instrument() {

        this.musicians = new HashSet<>();
    }

    public Set<Musician> getMusicians(){

        return new HashSet<>(this.musicians);
    }

    public void addMusician(Musician m){

        this.musicians.add(m);
    }
}
