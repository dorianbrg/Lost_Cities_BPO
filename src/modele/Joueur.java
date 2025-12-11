package modele;

import modele.carte.Couleur;
import modele.carte.Expedition;
import modele.carte.Main;
import modele.strategie.Strategie;

import java.util.HashMap;
import java.util.Map;

public class Joueur {
    private final String nom;
    private Main main;
    private Strategie strategie;
    private Map<Couleur, Expedition> expeditions;

    public Joueur(String nom) {
        this.nom = nom;
        this.main = new Main();
        this.expeditions = new HashMap<>();
        for (Couleur c : Couleur.values()) {
            this.expeditions.put(c,new Expedition(c));
        }
    }

    private void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    private Coup choisirCoup(Jeu jeu) {
        return strategie.choisirCoup(jeu);
    }

    private Couleur choisirPioche(Jeu jeu) {
        return strategie.choisirPioche(jeu);
    }

    public int getScore() {
        int total = 0;
        for (Couleur couleur : Couleur.values()) {
            total += getExpedition(couleur).calculerScore();
        }
        return total;
    }

    public Expedition getExpedition(Couleur couleur) {
        return this.expeditions.get(couleur);
    }

    public String getNom() {
        return this.nom;
    }

    public Main getMain() {
        return this.main;
    }


}
