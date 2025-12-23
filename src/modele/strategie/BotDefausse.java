package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.TypeCoup;
import modele.carte.Couleur;

public class BotDefausse implements Strategie {
    public Coup choisirCoup(Jeu jeu) {
        return new Coup(0, TypeCoup.DEFAUSSER);
    }

    public Couleur choisirPioche(Jeu jeu) {
        return null;
    }
}
