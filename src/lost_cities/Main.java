package lost_cities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends PaquetBase {
    List<Carte> main;

    public Main() {
        this.main = new ArrayList<>();
    }

    public void ajouterCartes(Carte... cartes) {
        for (Carte c: cartes) {
            if (this.main.size() < 8) {
                this.main.add(c);
            }
            else {
                throw new IllegalArgumentException("La main est déjà pleine (8 cartes max)");
            }
        }
    }

    public void ajouterCartes(Collection<Carte> cartes) {
        for (Carte c: cartes) {
            if (this.main.size() < 8) {
                this.main.add(c);
            }
            else {
                throw new IllegalArgumentException("La main est déjà pleine (8 cartes max)");
            }
        }
    }

    public Carte prendreCarte(int indice) { // l'indice doit être compris entre 0 et 7
        return this.main.remove(indice);
    }
}
