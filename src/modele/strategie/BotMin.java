package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.TypeCoup;
import modele.carte.Carte;
import modele.carte.Couleur;

public class BotMin implements Strategie {
    public Coup choisirCoup(Jeu jeu) {
        Coup coup;
        Carte minCarte = null;
        for (Carte c: jeu.getJoueurCourant().getMain()) {
            if (jeu.getJoueurCourant().getExpedition(c.getCouleur()).peutPoser(c)) {
                if ((minCarte == null) || (minCarte.getCarte().getValeur() > c.getCarte().getValeur()) ) {
                    minCarte = c;
                }
            }
        }
        if (minCarte != null) { // il y a au moins une carte jouable
            int ind = jeu.getJoueurCourant().getMain().getIndice(minCarte); // indice de la plus petite carte parmis les cartes jouables
            coup = new Coup(ind, TypeCoup.JOUER);
            return coup;
        }
        else { // Aucune carte jouable, on défausse la plus petite

            jeu.getJoueurCourant().getMain().trierMainVal(); // On tri par valeurs pour récupérer la plus petite carte
            coup = new Coup(0, TypeCoup.DEFAUSSER); // On défausse la plus petite carte
            jeu.getJoueurCourant().getMain().ajouterCartes(); // On ajoute rien mais on retrie les cartes avec l'ordre naturel de base (méthode trier())
            return coup;
        }
    }

    public Couleur choisirPioche(Jeu jeu) {
        return null; // null = pioche principal
    }

    public String getStrategie() {
        return "BotMin";
    }
}
