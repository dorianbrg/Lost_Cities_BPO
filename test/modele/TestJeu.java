package modele;

import modele.carte.Carte;
import modele.carte.Couleur;
import modele.carte.TypeCarte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJeu {
    @Test
    public void testInitialisation() {
        Jeu jeu = new Jeu();

        assertEquals(60,jeu.getPioche().getNbCartes());
        assertEquals(8,jeu.getJoueur(0).getMain().getNbCartes());
        assertEquals(8,jeu.getJoueur(1).getMain().getNbCartes());
        for(Couleur c: Couleur.values()) {
            assertTrue(jeu.getDefausse(c).estVide());
        }
    }
}
