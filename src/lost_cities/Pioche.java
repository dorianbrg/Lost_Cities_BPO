package lost_cities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pioche extends PaquetBase {

    public void init(Carte... cartes) {
        ajouterCartes(cartes);
        melanger();
    }

    public void init(Collection<Carte> cartes) {
        ajouterCartes(cartes);
        melanger();
    }

    public Carte prendreCarte() { // prend la dernière carte sur la pile
        return prendreDerniereCarte();
    }
}
