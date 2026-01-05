package controle;

import modele.Coup;
import modele.Jeu;
import modele.Joueur;
import modele.TypeCoup;
import modele.carte.Couleur;
import vue.Statistiques;
import vue.VueJeu;

public class ControleJeu {
    private Jeu jeu;
    private VueJeu vue;
    private Statistiques stats;

    public ControleJeu(Jeu jeu, VueJeu vue, Statistiques stats) {
        this.jeu = jeu;
        this.vue = vue;
        this.stats = stats;
    }

    public void lancerJeu() {
        while (!jeu.estFini()) {
            // Afficher le joueur courant
            System.out.println("Au tour de " + jeu.getJoueurCourant().getNom() + " !");
            vue.afficherJoueurCourant(jeu);

            // Phase 1: Jouer ou défausser
            Joueur joueurCourant = jeu.getJoueurCourant();
            Coup coup = joueurCourant.choisirCoup(jeu);
            boolean coupValide = jeu.jouer(coup);
            if ( (coupValide) && (coup.getTypeCoup() == TypeCoup.JOUER) ) { // On incrémente le nombre de cartes jouées
                stats.incrCartesJouees();
            }
            else if ( (coupValide) && (coup.getTypeCoup() == TypeCoup.DEFAUSSER) ) { // On incrémente le nombre de cartes jouées
                stats.incrCartesDef();
            }

            while (!(coupValide)) { // Si le coup est invalide, on redemande
                System.out.println("Ce coup est invalide, veuillez en refaire un.");
                coup = joueurCourant.choisirCoup(jeu);
                coupValide = jeu.jouer(coup);
                if ( (coupValide) && (coup.getTypeCoup() == TypeCoup.JOUER) ) {
                    stats.incrCartesJouees();
                }
                else if ( (coupValide) && (coup.getTypeCoup() == TypeCoup.DEFAUSSER) ) { // On incrémente le nombre de cartes jouées
                    stats.incrCartesDef();
                }
            }

            // Phase 2: Piocher
            Couleur pioche = joueurCourant.choisirPioche(jeu);
            boolean piocheValide = jeu.piocher(pioche);
            while (!(piocheValide)) { // Si le coup est invalide, on redemande
                System.out.println("Ce coup est invalide, veuillez en refaire un.");
                pioche = joueurCourant.choisirPioche(jeu);
                piocheValide = jeu.piocher(pioche);
            }

            // Passer au joueur suivant
            System.out.println("Tour de " + jeu.getJoueurCourant().getNom() + " fini !");
            jeu.passerJoueurSuivant();
        }
        vue.afficher(jeu);
        System.out.println("Le jeu est terminé !");
        stats.incrParties(); // La partie est finie, on incrémente le nombre de parties

        // Afficher les scores finaux
        vue.afficherScores(jeu);

        // Afficher les statistiques de la partie
        vue.afficherStats(stats);




    }

}
