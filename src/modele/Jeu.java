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

    public Jeu(String nom1, String nom2) {
        // Création des joueurs
        this.joueur0 = new Joueur(nom1);
        this.joueur1 = new Joueur(nom1);

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
                Carte carte = new Carte(c, t);
                this.pioche.init(carte);
            }
        }
    }

    public boolean jouer(Coup coup) {
        Carte carteEnMain;
        if (joueurCourant == 0) {
            carteEnMain = this.joueur0.getMain().voirCarte(coup.getIndCarte());
        }
        else {
            carteEnMain = this.joueur1.getMain().voirCarte(coup.getIndCarte());
        }
        if ( (coup.getTypeCoup() == TypeCoup.JOUER) && (carteEnMain != null) ) { // Cas où le coup est JOUER
            if (joueurCourant == 0) {
                boolean peutPoser = this.joueur0.getExpedition(carteEnMain.getCouleur()).poser(carteEnMain);
                if (peutPoser) {
                    this.joueur0.getMain().prendreCarte(coup.getIndCarte());
                    return peutPoser;
                }
                else {
                    return false;
                }
            }
            else {
                boolean peutPoser = this.joueur1.getExpedition(carteEnMain.getCouleur()).poser(carteEnMain);
                if (peutPoser) {
                    this.joueur1.getMain().prendreCarte(coup.getIndCarte());
                    return peutPoser;
                }
                else {
                    return false;
                }
            }
        }
        else if ( (coup.getTypeCoup() == TypeCoup.DEFAUSSER) && (carteEnMain != null) ){ // Cas où le coup est DEFAUSSER
            return this.defausses.get(carteEnMain.getCouleur()).poser(carteEnMain);
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
            if ( (joueurCourant == 0) && (cartePioche.compareTo(this.joueur0.getLastCarteDefausse()) != 0) ){
                this.joueur0.getMain().ajouterCartes(cartePioche);
                return true;
            }
            else if ( (joueurCourant == 1) && (cartePioche.compareTo(this.joueur1.getLastCarteDefausse()) != 0) ) {
                this.joueur1.getMain().ajouterCartes(cartePioche);
                return true;
            }
            else { // Cas où la carte pioché est l'ancienne défaussé par le jour, or cela ne doit pas être le cas
                return false;
            }
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
