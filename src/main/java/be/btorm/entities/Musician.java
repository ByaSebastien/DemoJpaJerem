package be.btorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Musician implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<Instrument> instruments;

    public Musician() {

        this.instruments = new HashSet<>();
    }

    public Set<Instrument> getInstruments(){

        return new HashSet<>(this.instruments);
    }

    public void addInstrument(Instrument i){

        this.instruments.add(i);
        i.addMusician(this);
    }
}