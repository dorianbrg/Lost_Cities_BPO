package modele.carte;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarte {
    @Test
    public void testComparaison() {
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.JAUNE, TypeCarte.TROIS);
        assertTrue(c1.compareTo(c2) < 0);
    }

    @Test
    public void testCarteIdentique() {
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);

        assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void testOrdreTri() {
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);
        Carte c4 = new Carte(Couleur.BLEU, TypeCarte.DEUX);
        Carte c5 = new Carte(Couleur.JAUNE, TypeCarte.TROIS);

        assertTrue(c1.compareTo(c4) < 0);
        assertTrue(c1.compareTo(c5) < 0);
    }



}
