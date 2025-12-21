package modele.strategie;

import modele.Coup;
import modele.Jeu;
import org.junit.jupiter.api.Test;

public class TestBot {
    @Test
    public void TestCoupBots() {
        Jeu jeu = new Jeu("Bot1","Bot2");
        jeu.getJoueur(0).setStrategie(new BotMin());
        jeu.getJoueur(1).setStrategie(new BotMin());

        Coup coup1 = jeu.getJoueurCourant().
    }
}
