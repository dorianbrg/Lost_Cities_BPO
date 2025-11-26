package modele.carte;

import java.util.stream.Stream;

public interface Paquet extends Iterable<Carte> {
    boolean estVide();
    int getNbCartes();
    Carte voirCarte(int indice);
    Carte voirPremiereCarte();
    Carte voirDerniereCarte();
    Stream<Carte> cartes();
    int getIndice (Carte carte);
}
