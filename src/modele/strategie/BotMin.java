package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.TypeCoup;
import modele.carte.Carte;
import modele.carte.Couleur;

import static modele.carte.Carte.COMP_VAL;

public class BotMin implements Strategie {
    public Coup choisirCoup(Jeu jeu) {
        Coup coup;
        for (Carte c: jeu.getJoueurCourant().getMain()) {
            if (jeu.getJoueurCourant().getExpedition(c.getCouleur()).peutPoser(c)) {
                int ind = jeu.getJoueurCourant().getMain().getIndice(c);
                coup = new Coup(ind, TypeCoup.JOUER);
            }
        }
        jeu.getJoueurCourant().getMain().(COMP_VAL);
    }



    public Couleur choisirPioche(Jeu jeu) {
        return null; // null = pioche principal
    }
}
