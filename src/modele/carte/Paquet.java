package modele.carte;

import java.util.stream.Stream;

public interface Paquet extends Iterable<Carte> {
    default boolean estVide() {
        return (getNbCartes() == 0);
    }
    default Carte voirPremiereCarte() {
        if (estVide()) {
            return null;
        }
        return voirCarte(0);
    }
    default Carte voirDerniereCarte() {
        if (estVide()) {
            return null;
        }
        return voirCarte(getNbCartes()-1);
    }
    int getNbCartes();
    Carte voirCarte(int indice);
    Stream<Carte> cartes();
    int getIndice (Carte carte);
}
