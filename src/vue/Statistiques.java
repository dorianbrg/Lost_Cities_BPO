package vue;

import modele.Jeu;
import modele.carte.Couleur;

import java.util.HashMap;
import java.util.Map;

public class Statistiques {
    private int nbParties;
    private int cartesJouees;
    private int cartesDef;
    private Map<Couleur, Double> scoreMoyenExp = new HashMap<>();
    private double VicBotMin;
    private double VicBotDefausse;

    public int getCartesJouees() {
        return cartesJouees;
    }

    public int getCartesDef() {
        return cartesDef;
    }

    public void afficherScoreMoyenExp() {
        System.out.print("| ");
        for(Couleur c: Couleur.values()) {
            System.out.print(c.txt(scoreMoyenExp.get(c) / (2 * nbParties) + "") + " | ");
        }
        System.out.println("");
    }

    public double getVicBotMin() {
        return VicBotMin;
    }

    public void incrCartesJouees() {
        cartesJouees += 1;
    }

    public void incrCartesDef() {
        cartesDef += 1;
    }

    public void incrParties() {
        nbParties += 1;
    }

    public int getNbParties() {
        return nbParties;
    }

    public void updateScoreMoy(Jeu jeu) {
        for(Couleur c: Couleur.values()) {
            scoreMoyenExp.put(c, scoreMoyenExp.getOrDefault(c, 0.0) + jeu.getJoueur(0).getExpedition(c).calculerScore());
            scoreMoyenExp.put(c, scoreMoyenExp.getOrDefault(c, 0.0) + jeu.getJoueur(1).getExpedition(c).calculerScore());
        }
    }

    public double getVicBotDefausse() {
        return VicBotDefausse;
    }
}
