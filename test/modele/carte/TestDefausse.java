package modele.carte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestDefausse {
    @Test
    public void testConstructeur() {
        Defausse d = new Defausse(Couleur.ROUGE);

        assertNotEquals(null,d);
    }

    @Test
    public void testDefausser() {
        Defausse d = new Defausse(Couleur.ROUGE);
        Carte c1 = new Carte(Couleur.ROUGE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.ROUGE, TypeCarte.TROIS);
        Carte c3 = new Carte(Couleur.ROUGE, TypeCarte.PARI);

        d.poser(c1);
        d.poser(c2);
        d.poser(c3);

        assertEquals(3,d.getNbCartes());
    }

    @Test
    public void testDefausserAutreCouleur
}
