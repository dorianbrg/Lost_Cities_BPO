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
        // On détermine ici la plus petite carte jouable de la main par valeur
        for (Carte c: jeu.getJoueurCourant().getMain()) {
            if (jeu.getJoueurCourant().getExpedition(c.getCouleur()).peutPoser(c)) { // Pour filtrer les cartes jouables
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

            jeu.getJoueurCourant().getMain().trierMainVal(); // On trie ici par valeurs pour récupérer la plus petite carte, il s'agit d'une deuxième méthode pour obtenir les cartes par valeur
            Carte ppCarte = jeu.getJoueurCourant().getMain().voirCarte(0); // On récupère la plus petite carte
            jeu.getJoueurCourant().getMain().ajouterCartes(); // On ajoute rien mais on retrie les cartes avec l'ordre naturel de base (méthode trier()) après l'avoir trié par valeurs (sécurité supplémentaire)
            return new Coup(jeu.getJoueurCourant().getMain().getIndice(ppCarte), TypeCoup.DEFAUSSER); // On défausse la plus petite carte
        }
    }

    public Couleur choisirPioche(Jeu jeu) {
        return null; // null = pioche principal
    }

    public String getStrategie() {
        return "BotMin";
    }
}
