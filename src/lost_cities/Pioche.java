package lost_cities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pioche extends PaquetBase {
    List<Carte> pioche;

    public Pioche() {
        this.pioche = new ArrayList<>();
    }

    public void ajouterCartes(Carte... cartes) {
        for (Carte c: cartes) {
            this.pioche.add(c);
        }
    }

    public void ajouterCartes(Collection<Carte> cartes) {
        for (Carte c: cartes) {
            this.pioche.add(c);
        }
    }

    public Carte prendreCarte() { // prend la dernière carte sur la pile
        return this.pioche.removeLast();
    }
}
