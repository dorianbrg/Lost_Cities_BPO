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
}
