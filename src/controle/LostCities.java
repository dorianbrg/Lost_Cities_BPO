package controle;

import modele.Jeu;
import modele.Joueur;
import modele.strategie.BotMin;
import modele.strategie.Humain;
import vue.Statistiques;
import vue.VueJeu;
import vue.VueJeuCLI;

import java.util.Scanner;

public class LostCities {
    public static void main(String[] args) {
        // Créer la vue
        VueJeu vue = new VueJeuCLI();

        // Créer le jeu
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur 1:");
        String nom1 = sc.nextLine();

        System.out.println("Entrez le nom du joueur 2:");
        String nom2 = sc.nextLine();

        Jeu jeu = new Jeu(nom1,nom2);

        // Configurer les joueurs
        System.out.println("Veuillez entrer le type du joueur 1 (Humain ou Bot):");
        String type1 = sc.nextLine();
        while ( (!type1.equalsIgnoreCase("Humain")) && (!type1.equalsIgnoreCase("Bot")) ) {
            System.out.println("Veuillez renseigner un type valide (Humain ou Bot):");
            type1 = sc.nextLine();
        }

        System.out.println("Veuillez entrer le type du joueur 2 (Humain ou Bot):");
        String type2 = sc.nextLine();
        while ( (!type2.equalsIgnoreCase("Humain")) && (!type2.equalsIgnoreCase("Bot")) ) {
            System.out.println("Veuillez renseigner un type valide (Humain ou Bot):");
            type2 = sc.nextLine();
        }

        Joueur joueur1 = jeu.getJoueur(0);
        if (type1.equalsIgnoreCase("Humain") ) {
            joueur1.setStrategie(new Humain(vue));
        }
        else {
            joueur1.setStrategie(new BotMin());
        }
        Joueur joueur2 = jeu.getJoueur(1);
        if (type2.equalsIgnoreCase("Humain") ) {
            joueur2.setStrategie(new Humain(vue));
        }
        else {
            joueur2.setStrategie(new BotMin());
        }

        // Créer le controleur et lancer la partie
        Statistiques stats_generales = new Statistiques();
        ControleJeu controle = new ControleJeu(jeu, vue, stats_generales);
        controle.lancerJeu();
    }

}
