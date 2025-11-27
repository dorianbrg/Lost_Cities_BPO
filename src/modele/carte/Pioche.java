package modele.carte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pioche extends PaquetBase implements Piochable {

    public void init(Carte... cartes) {
        ajouterCartes(cartes);
        melanger();
    }

    public void init(Collection<Carte> cartes) {
        ajouterCartes(cartes);
        melanger();
    }

    public Carte prendreCarte() { // prend la première carte sur la pile
        return prendrePremiereCarte(); // on considère la pioche face retournée, donc la première carte est celle tout au dessus du tas
    } // Le cas de la pioche vide est déjà géré dans PaquetBase
}
