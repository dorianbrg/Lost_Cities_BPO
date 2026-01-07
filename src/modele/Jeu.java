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
        this.joueur1 = new Joueur(nom2);

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

    // Méthode utilisée dans le constrcuteur pour créer toutes les cartes
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
        // On va d'abord regarder la carte, car on ne sait encore si elle est jouable (sauf pour les bots où leur implémentation ne permet pas de faire des coups invalides)
        if (joueurCourant == 0) {
            carteEnMain = this.joueur0.getMain().voirCarte(coup.getIndCarte());
        }
        else {
            carteEnMain = this.joueur1.getMain().voirCarte(coup.getIndCarte());
        }
        if ( (coup.getTypeCoup() == TypeCoup.JOUER) && (carteEnMain != null) ) { // Cas où le coup est JOUER et que la carte peut être accessible (indice correct)
            if (joueurCourant == 0) {
                boolean peutPoser = this.joueur0.getExpedition(carteEnMain.getCouleur()).poser(carteEnMain); // On vérifie si on peut poser la carte
                if (peutPoser) { // Si c'est le cas, on pose
                    this.joueur0.getMain().prendreCarte(coup.getIndCarte());
                    return peutPoser;
                }
                else { // Sinon le coup est invalide
                    return false;
                }
            }
            else { // Si le joueur courant est le joueur 1
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
            if (joueurCourant == 0) {
                this.joueur0.getMain().prendreCarte(coup.getIndCarte()); // On enlève la carte de sa main
                this.joueur0.setLastCarteDefausse(carteEnMain); // Comme on défausse, on met à jour la dernière carte défaussée du joueur
                return this.defausses.get(carteEnMain.getCouleur()).poser(carteEnMain); // On pose la carte dans la défausse et on renvoie true
            }
            else { // Idem pour l'autre joueur
                this.joueur1.getMain().prendreCarte(coup.getIndCarte());
                this.joueur1.setLastCarteDefausse(carteEnMain);
                return this.defausses.get(carteEnMain.getCouleur()).poser(carteEnMain);
            }
        }
        return false; // Cas où carteEnMain est null
    }

    public boolean piocher(Couleur couleur) {
        Carte cartePioche;
        // Idem, on regarde la carte avant de savoir si on peut réellement la piocher.
        if (couleur == null) {
            cartePioche = this.pioche.voirPremiereCarte();
        }
        else {
            cartePioche = this.defausses.get(couleur).voirDerniereCarte();
        }
        if (cartePioche != null) {
            // Récupération des dernières cartes défaussées des joueurs
            Carte lastCarteDefJ0 = this.joueur0.getLastCarteDefausse();
            Carte lastCarteDefJ1 = this.joueur1.getLastCarteDefausse();
            // S'il s'agit de la pioche principal, aucun soucis
            if ( (couleur == null) && (joueurCourant == 0) ) {
                this.joueur0.getMain().ajouterCartes(cartePioche);
                this.pioche.prendreCarte();
                return true;
            }
            else if ( (couleur == null) && (joueurCourant == 1) ) {
                this.joueur1.getMain().ajouterCartes(cartePioche);
                this.pioche.prendreCarte();
                return true;
            }
            // Si c'est une défausse on compare la carte que l'on souhaite piocher avec l'ancienne carte défaussée du joueur
            else if ( (joueurCourant == 0) && (lastCarteDefJ0 == null || (cartePioche.compareTo(lastCarteDefJ0) != 0) ) ){
                this.joueur0.getMain().ajouterCartes(cartePioche);
                this.defausses.get(couleur).prendreCarte();
                return true;
            }
            else if ( (joueurCourant == 1) && (lastCarteDefJ1 == null || (cartePioche.compareTo(lastCarteDefJ1) != 0) ) ) {
                this.joueur1.getMain().ajouterCartes(cartePioche);
                this.defausses.get(couleur).prendreCarte();
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

    // Méthode déterminant le joueur qui a gagné (ou pas) la partie
    public Joueur getJoueurGagnant() {
        if ((this.joueur0.getScore() > this.joueur1.getScore())) {
            return this.joueur0;
        }
        else if ((this.joueur0.getScore() < this.joueur1.getScore())) {
            return this.joueur1;
        }
        else { // Cas d'égalité
            return null;
        }
    }

    public Joueur getJoueurPerdant() {
        if ((this.joueur0.getScore() > this.joueur1.getScore())) {
            return this.joueur1;
        }
        else if ((this.joueur0.getScore() < this.joueur1.getScore())) {
            return this.joueur0;
        }
        else {
            return null;
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
