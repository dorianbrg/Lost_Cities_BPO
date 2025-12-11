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
        Jeu jeu = new Jeu("nom1","nom2");

        assertEquals(44,jeu.getPioche().getNbCartes()); // 44 cartes car 60 - les cartes distribués aux joueurs
        assertEquals(8,jeu.getJoueur(0).getMain().getNbCartes());
        assertEquals(8,jeu.getJoueur(1).getMain().getNbCartes());
        for(Couleur c: Couleur.values()) {
            assertTrue(jeu.getDefausse(c).estVide());
        }
    }

    @Test
    public void testCoupValide() {
        Jeu jeu = new Jeu("nom1","nom2");
        Coup coupValide = new Coup(0,TypeCoup.JOUER); // tous les coups sont valides si les expéditions sont vides

        assertTrue(jeu.jouer(coupValide));
        assertEquals(7,jeu.getJoueurCourant().getMain().getNbCartes());
    }


}
