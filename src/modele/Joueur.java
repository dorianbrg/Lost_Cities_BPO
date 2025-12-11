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
}
