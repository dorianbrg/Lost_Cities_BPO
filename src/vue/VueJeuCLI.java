package vue;

import modele.Coup;
import modele.Jeu;
import modele.Joueur;
import modele.TypeCoup;
import modele.carte.Couleur;

import java.util.Scanner;

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

    public Coup demanderCoup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle carte souhaitez-vous jouer ? (renseigner l'indice)");
        int ind = sc.nextInt();
        while ((ind < 0) || (ind > 7)) {
            System.out.println("Veuillez renseigner un indice valide:");
            ind = sc.nextInt();
        }

        System.out.println("Souhaitez-vous la joeur ou la défausser ?");
        String type = sc.nextLine();
        while ( (!(type.equalsIgnoreCase("Jouer")) && (!type.equalsIgnoreCase("Défausser"))) ) {
            System.out.println("Veuillez renseigner une action valide (jouer ou défausser):");
            type = sc.nextLine();
        }

        if (type.equalsIgnoreCase("Jouer")) {
            return new Coup(ind, TypeCoup.JOUER);
        }
        else if (type.equalsIgnoreCase("Défausser")) {
            return new Coup(ind, TypeCoup.DEFAUSSER);
        }
        return null;
    }

    public Couleur demanderPioche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle pioche ? (P pour la principale/la couleur de la défausse choisie sinon)");
        String pioche = sc.nextLine();
        while ( (!pioche.equalsIgnoreCase("P")) && (!pioche.equalsIgnoreCase("Jaune")) && (!pioche.equalsIgnoreCase("Blanc")) && (!pioche.equalsIgnoreCase("Bleu")) && (!pioche.equalsIgnoreCase("Rouge")) && (!pioche.equalsIgnoreCase("Vert")) ){
            System.out.println("Renseignez une pioche valide (P pour la principale/la couleur de la défausse choisie sinon)");
            pioche = sc.nextLine();
        }

        if (pioche.equalsIgnoreCase("P")) {
            return null;
        }
        else {
            for(Couleur c: Couleur.values()) {
                if (pioche.equalsIgnoreCase("" + c)) {
                    return c;
                }
            }
        }
        System.out.println("Je n'ai pas trouvé la pioche");
        return null;
    }

    public void afficherJoueurCourant(Jeu jeu) {
        // Affichage de la main du joueur courant
        System.out.println("| ");
        for(int i = 0; i < jeu.getJoueurCourant().getMain().getNbCartes(); i++) {
            System.out.print(i + ": " + jeu.getJoueurCourant().getMain().voirCarte(i) + " | ");
        }
    }

    public void afficherScores(Jeu jeu) {
        Joueur j0 = jeu.getJoueur(0);
        Joueur j1 = jeu.getJoueur(1);
        System.out.println("Score de " + j0.getNom() + " : " +
                j0.getScore());
        System.out.println("Score de " + j1.getNom() + " : " +
                j1.getScore());
    }
}
