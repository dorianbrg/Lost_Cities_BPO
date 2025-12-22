package vue;

import modele.Coup;
import modele.Jeu;
import modele.carte.Couleur;

public interface VueJeu {
    void afficherJoueurCourant(Jeu jeu);
    void afficher(Jeu jeu);
    void afficherScores(Jeu jeu);
    Coup demanderCoup();
    Couleur demanderPioche();
}
