package be.btorm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class Province{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String name;

    public Province(String name) {
        this.name = name;
    }

    @OrderBy("name")
    @OneToMany(mappedBy = "province")
    private List<Municipality> municipalities = new ArrayList<>();

    public List<Municipality> getMunicipalities() {
        return List.copyOf(municipalities);
    }

    public void addMunicipality(Municipality municipality){
        this.municipalities.add(municipality);
    }

    public void removeMunicipality(Municipality municipality){
        this.municipalities.remove(municipality);
    }
}
