package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.TypeCoup;
import modele.carte.Carte;
import modele.carte.Couleur;

public class BotMin implements Strategie {
    public Coup choisirCoup(Jeu jeu) {
        Coup coup;
        for (Carte c: jeu.getJoueurCourant().getMain()) {
            if (jeu.getJoueurCourant().getExpedition(c.getCouleur()).peutPoser(c)) {
                int ind = jeu.getJoueurCourant().getMain().getIndice(c); // mais ce n'est pas forcément la plus petite carte de toute la main entiere
                coup = new Coup(ind, TypeCoup.JOUER);
                return coup;
            }
        }

        jeu.getJoueurCourant().getMain().trierMainVal(); // On tri par valeurs pour récupérer la plus petite carte
        coup = new Coup(0,TypeCoup.DEFAUSSER); // On défausse la plus petite carte
        jeu.getJoueurCourant().setLastCarteDefausse(jeu.getJoueurCourant().getMain().voirCarte(0)); // On set la dernière carte défaussé du joueur quand le coup est DEFAUSSER
        jeu.getJoueurCourant().getMain().ajouterCartes(); // On ajoute rien mais on retrie les cartes avec l'ordre naturel de base (méthode trier())
        return coup;
    }

    public Couleur choisirPioche(Jeu jeu) {
        return null; // null = pioche principal
    }
}
