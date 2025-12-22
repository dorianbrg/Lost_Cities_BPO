package vue;

import modele.Jeu;
import modele.carte.Couleur;

public class VueJeuCLI implements VueJeu {
    public void afficher(Jeu jeu) {
        // Affichage des expéditions de chaque joueur
        for (int i = 0; i <= 1; i++) {
            System.out.println("Expéditions de " + jeu.getJoueur(i).getNom() + ":");
            for(Couleur c: Couleur.values()) {
                System.out.println(c + ": " + jeu.getJoueur(i).getExpedition(c));
            }
        }

        // Affichage de la main du joueur courant
        System.out.println("Main: " + jeu.getJoueurCourant().getMain());

        // Défausses
        System.out.println("Les cartes visibles des défausses sont:");
        System.out.println("| ");
        for(Couleur c: Couleur.values()) {
            System.out.print(jeu.getDefausse(c).voirPremiereCarte() + " | ");
        }

        // Cartes de la pioche restantes
        System.out.println("Il reste " + jeu.getPioche().getNbCartes() + " dans la pioche.");
    }
}
