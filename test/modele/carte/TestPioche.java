package modele.carte;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPioche {
    @Test
    public void testInitPioche() {
        Pioche p = new Pioche();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        p.init(c1,c2,c3);

        assertEquals(3,p.getNbCartes());
    }

    @Test
    public void testPiocheVide() {
        Pioche p = new Pioche();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        p.init(c1,c2,c3);
        p.prendreCarte();
        p.prendreCarte();
        p.prendreCarte();

        assertTrue(p.estVide());
    }

    @Test
    public void testPiocherDansVide() {
        Pioche p = new Pioche();

        Carte res = p.prendreCarte();

        assertNull(res);
    }

    @Test
    public void testMelange() {
        Pioche p = new Pioche();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        p.init(c1,c2,c3);
        List<Carte> res = new ArrayList<>();
        res.add(c1);
        res.add(c2);
        res.add(c3);

        assertNotEquals(res.stream(),p.cartes());
    }
}
