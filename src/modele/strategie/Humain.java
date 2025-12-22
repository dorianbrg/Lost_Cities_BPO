package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.carte.Couleur;
import vue.VueJeu;

public class Humain implements Strategie {
    private VueJeu vue;

    public Humain(VueJeu vue) {
        this.vue = vue;
    }

    public Coup choisirCoup(Jeu jeu) {
        vue.afficher();
        vue.demanderCoup();
        return Coup();
    }

    public Couleur choisirPioche(Jeu jeu) {
        vue.demanderPioche();
    }
}
