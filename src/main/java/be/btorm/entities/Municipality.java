package be.btorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Municipality {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;


    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mayor")
    private Mayor mayor;

    @Getter
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Province province;

    public void setProvince(Province province) {
        this.province = province;
        province.addMunicipality(this);
    }

    public void setMayor(Mayor mayor){
        this.mayor = mayor;
        mayor.setMunicipality(this);
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipality that = (Municipality) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
