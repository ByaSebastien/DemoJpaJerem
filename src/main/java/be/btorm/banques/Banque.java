package be.btorm.banques;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Builder
public class Banque {

    private List<InterfaceFonctionelle> event = new ArrayList<>();

    private Double solde;

    public Banque(Double solde) {
        this.solde = solde;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
        if(this.solde < 0){
            raise();
        }
    }

    public void subscribe(InterfaceFonctionelle i){
        event.add(i);
    }

    private void raise(){
        for (InterfaceFonctionelle i : event){
            i.execute();
        }
    }
}
