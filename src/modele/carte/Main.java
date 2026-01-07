package modele.carte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends PaquetBase {

    @Override
    public void ajouterCartes(Carte... cartes) {
        super.ajouterCartes(cartes);
        trier();
    }

    @Override
    public void ajouterCartes(Collection<Carte> cartes) {
        super.ajouterCartes(cartes);
        trier();
    }

    @Override
    public Carte prendreCarte(int indice) { // l'indice doit être compris entre 0 et 7
        return super.prendreCarte(indice);
    }


    public void trierMainVal() {
        this.trierVal();
    }
}
