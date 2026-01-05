package controle;

import modele.Jeu;
import modele.Joueur;
import modele.strategie.BotDefausse;
import modele.strategie.BotMin;
import modele.strategie.Humain;
import vue.Statistiques;
import vue.VueJeu;
import vue.VueJeuCLI;

import java.util.Scanner;

public class LostCities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Statistiques stats_generales = new Statistiques(); // On garde la même instance pour toutes les parties

        String rep;
        do {
            // Création de la vue
            VueJeu vue = new VueJeuCLI();

            // Création du jeu
            System.out.println("Entrez le nom du joueur 1:");
            String nom1 = sc.nextLine();

            System.out.println("Entrez le nom du joueur 2:");
            String nom2 = sc.nextLine();

            Jeu jeu = new Jeu(nom1, nom2);

            // Configuration joueur 1
            System.out.println("Veuillez entrer le type du joueur 1 (Humain ou Bot):");
            String type1 = sc.nextLine();
            while ((!type1.equalsIgnoreCase("Humain")) && (!type1.equalsIgnoreCase("Bot"))) {
                System.out.println("Veuillez renseigner un type valide (Humain ou Bot):");
                type1 = sc.nextLine();
            }

            Joueur joueur1 = jeu.getJoueur(0);
            if (type1.equalsIgnoreCase("Humain")) {
                joueur1.setStrategie(new Humain(vue));
            } else {
                System.out.println("Quel type de bots ? (BotMin ou BotDef)");
                String ssType1 = sc.nextLine();
                while ((!ssType1.equalsIgnoreCase("BotMin")) && (!ssType1.equalsIgnoreCase("BotDef"))) {
                    System.out.println("Veuillez renseigner un sous-type valide (BotMin ou BotDef):");
                    ssType1 = sc.nextLine();
                }
                if (ssType1.equalsIgnoreCase("BotMin")) {
                    joueur1.setStrategie(new BotMin());
                } else {
                    joueur1.setStrategie(new BotDefausse());
                }
            }

            // Configuration joueur 2
            System.out.println("Veuillez entrer le type du joueur 2 (Humain ou Bot):");
            String type2 = sc.nextLine();
            while ((!type2.equalsIgnoreCase("Humain")) && (!type2.equalsIgnoreCase("Bot"))) {
                System.out.println("Veuillez renseigner un type valide (Humain ou Bot):");
                type2 = sc.nextLine();
            }

            Joueur joueur2 = jeu.getJoueur(1);
            if (type2.equalsIgnoreCase("Humain")) {
                joueur2.setStrategie(new Humain(vue));
            } else {
                System.out.println("Quel type de bots ? (BotMin ou BotDef)");
                String ssType2 = sc.nextLine();
                while ((!ssType2.equalsIgnoreCase("BotMin")) && (!ssType2.equalsIgnoreCase("BotDef"))) {
                    System.out.println("Veuillez renseigner un sous-type valide (BotMin ou BotDef):");
                    ssType2 = sc.nextLine();
                }
                if (ssType2.equalsIgnoreCase("BotMin")) {
                    joueur2.setStrategie(new BotMin());
                } else {
                    joueur2.setStrategie(new BotDefausse());
                }
            }

            // Lancer la partie (mêmes stats réutilisées)
            ControleJeu controle = new ControleJeu(jeu, vue, stats_generales);
            controle.lancerJeu();

            System.out.println("Voulez-vous rejouer une partie ? (Oui/Non)");
            rep = sc.nextLine();
            while ((!rep.equalsIgnoreCase("Oui")) && (!rep.equalsIgnoreCase("Non"))) {
                System.out.println("Voulez-vous rejouer une partie ? (Oui/Non)");
                rep = sc.nextLine();
            }

        } while (rep.equalsIgnoreCase("Oui"));

        sc.close();
    }

}
