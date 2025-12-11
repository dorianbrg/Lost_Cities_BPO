package modele;

import modele.carte.*;

import java.util.HashMap;
import java.util.Map;

public class Jeu {
    private int joueurCourant;
    private Pioche pioche;
    private Map<Couleur, Defausse> defausses;
    private Joueur joueur0;
    private Joueur joueur1;

    public Jeu() {
        // Création et initialisation de la pioche
        this.pioche = new Pioche();
        setPioche();

        // Création et initialisation des défausses
        this.defausses = new HashMap<>();
        for(Couleur c: Couleur.values()) {
            this.defausses.put(c,new Defausse(c));
        }

        // Distribution de 8 cartes de la pioches pour chaque joueur
        for(int i = 0; i < 8; i++) {
            this.joueur0.getMain().ajouterCartes(pioche.prendreCarte());
            this.joueur1.getMain().ajouterCartes(pioche.prendreCarte());
        }

        // Initialisation du joueur courant;
        this.joueurCourant = 0;

    }
    
    private void setPioche() {
        for(Couleur c: Couleur.values()) {
            for (TypeCarte t: TypeCarte.values()) {
                if (t.getValeur() == 0) {
                    Carte cartePari1 = new Carte(c,t);
                    Carte cartePari2 = new Carte(c,t);
                    this.pioche.init(cartePari1, cartePari2);
                }
                Carte carte = new Carte(c,t);
                this.pioche.init(carte);
            }
        }
    }

}
