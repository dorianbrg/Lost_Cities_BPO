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

    public boolean jouer(Coup coup) {
        Carte carteEnMain;
        if (joueurCourant == 0) {
            carteEnMain = this.joueur0.getMain().prendreCarte(coup.getIndCarte());
        }
        else {
            carteEnMain = this.joueur1.getMain().prendreCarte(coup.getIndCarte());
        }
        if ( (coup.getTypeCoup() == TypeCoup.JOUER) && (carteEnMain != null) ) { // Cas où le coup est JOUER
            if (joueurCourant == 0) {
                if (this.joueur0.getExpedition(carteEnMain.getCouleur()).poser(carteEnMain)) {
                    this.joueur0.getMain().prendreCarte(coup.getIndCarte());
                    return true;
                }
                else return false; // Coup invalide
            }
            else {
                if (this.joueur1.getExpedition(carteEnMain.getCouleur()).poser(carteEnMain)) {
                    this.joueur1.getMain().prendreCarte(coup.getIndCarte());
                    return true;
                }
                else return false;
            }
        }
        else if ( (coup.getTypeCoup() == TypeCoup.DEFAUSSER) && (carteEnMain != null) ){ // Cas où le coup est DEFAUSSER
            this.defausses.get(carteEnMain.getCouleur()).poser(carteEnMain);
            if (joueurCourant == 0) {
                this.joueur0.getMain().prendreCarte(coup.getIndCarte());
            }
            else {
                this.joueur1.getMain().prendreCarte(coup.getIndCarte());
            }
            return true;
        }
        return false; // Cas où carteEnMain est null
    }

    public boolean piocher(Couleur couleur) {
        Carte cartePioche;
        if (couleur == null) {
            cartePioche = this.pioche.prendreCarte();
        }
        else {
            cartePioche = this.defausses.get(couleur).prendreCarte(); // comment faire en sorte de pas pioche la derniere carte défaussé par le joueur courant?
        }
        if (cartePioche != null) {
            if (joueurCourant == 0) {
                this.joueur0.getMain().ajouterCartes(cartePioche);
            }
            else {
                this.joueur1.getMain().ajouterCartes(cartePioche);
            }
            return true;
        }
        return false;
    }

    public boolean estFini() {
        return this.pioche.estVide();
    }

    public void passerJoueurSuivant() {
        if (joueurCourant == 0) {
            this.joueurCourant = 1;
        }
        else {
            this.joueurCourant = 0;
        }
    }

    public Joueur getJoueur(int indice) {
        if (indice == 0) {
            return this.joueur0;
        }
        else if (indice == 1) {
            return this.joueur1;
        }
        else return null;
    }

    public Joueur getJoueurCourant() {
        if (joueurCourant == 0) {
            return this.joueur0;
        }
        else {
            return this.joueur1;
        }
    }

    public Pioche getPioche() {
        return this.pioche;
    }

    public Defausse getDefausse(Couleur couleur) {
        return this.defausses.get(couleur);
    }
}
