package controle;

import modele.Coup;
import modele.Jeu;
import modele.Joueur;
import modele.carte.Couleur;
import vue.VueJeu;

public class ControleJeu {
    private Jeu jeu;
    private VueJeu vue;

    public ControleJeu(Jeu jeu, VueJeu vue) {
        this.jeu = jeu;
        this.vue = vue;
    }

    public void lancerJeu() {
        while (!jeu.estFini()) {
            // Afficher le joueur courant
            vue.afficherJoueurCourant(jeu);
            
            // Phase 1: Jouer ou d\éfausser
            Joueur joueurCourant = jeu.getJoueurCourant();
            Coup coup = joueurCourant.choisirCoup(jeu);
            boolean coupValide = jeu.jouer(coup);

            while (!(coupValide)) { // Si le coup est invalide, on redemande
                System.err.println("Ce coup est invalide, veuillez en refaire un.");
                coup = joueurCourant.choisirCoup(jeu);
                coupValide = jeu.jouer(coup);
            }

            // Phase 2: Piocher
            Couleur pioche = joueurCourant.choisirPioche(jeu);
            jeu.piocher(pioche);

            // Passer au joueur suivant
            jeu.passerJoueurSuivant();
        }
        // Afficher les scores finaux
        vue.afficherScores(jeu);
    }

}
