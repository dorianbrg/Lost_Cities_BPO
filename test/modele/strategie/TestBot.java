package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.carte.Couleur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBot {
    @Test
    public void TestCoupBots() {
        Jeu jeu = new Jeu("Bot1","Bot2");
        jeu.getJoueur(0).setStrategie(new BotMin());
        jeu.getJoueur(1).setStrategie(new BotMin());

        Coup coup1 = jeu.getJoueurCourant().choisirCoup(jeu);
        System.out.println(coup1);
        assertTrue(jeu.jouer(coup1));
        assertTrue(jeu.piocher(jeu.getJoueurCourant().choisirPioche(jeu)));
        System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.JAUNE));
        System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.BLEU));
        System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.BLANC));
        System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.ROUGE));
        System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.VERT));

        jeu.passerJoueurSuivant();

        Coup coup2 = jeu.getJoueurCourant().choisirCoup(jeu);
        assertTrue(jeu.jouer(coup2));
        assertTrue(jeu.piocher(jeu.getJoueurCourant().choisirPioche(jeu)));
    }
}
