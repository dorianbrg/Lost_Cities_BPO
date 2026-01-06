package vue;

import modele.Jeu;
import modele.Joueur;
import modele.carte.Couleur;

import java.util.HashMap;
import java.util.Map;

public class Statistiques {
    private int nbParties;
    private int cartesJouees;
    private int cartesDef;
    private Map<Couleur, Double> scoreMoyenExp = new HashMap<>();
    private Map<String, Integer> victoires = new HashMap<>();
    private Map<String, Integer> parties = new HashMap<>();

    public Statistiques() {
        this.nbParties = 0;
        this.cartesJouees = 0;
        this.cartesDef = 0;
        this.victoires.put("Humain",0);
        this.victoires.put("BotMin",0);
        this.victoires.put("BotDef",0);
        this.parties.put("Humain",0);
        this.parties.put("BotMin",0);
        this.parties.put("BotDef",0);
    }

    public int getCartesJouees() {
        return cartesJouees;
    }

    public int getCartesDef() {
        return cartesDef;
    }

    public Map<Couleur, Double> getScoreMoyenExp() {
        return scoreMoyenExp;
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

    public void enregistrerPartie(String strategie) {
        parties.put(strategie, parties.get(strategie) + 1);
    }

    public void enregistrerVictoire(String strategie) {
            victoires.put(strategie, victoires.get(strategie) + 1);
    }

    public double getTauxVictoire(String strategie) {
        int p = parties.get(strategie);
        if (p == 0) return 0.0;
        return (victoires.get(strategie) * 100.0) / p;
    }

}
