package modele.carte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPaquet {
    @Test
    public void testMainVide() {
        Main m = new Main();

        assertTrue(m.estVide());
    }

    @Test
    public void testAjouterCartes() {
        Main m = new Main();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);
        Carte c4 = new Carte(Couleur.BLEU, TypeCarte.DEUX);
        Carte c5 = new Carte(Couleur.JAUNE, TypeCarte.TROIS);

        m.ajouterCartes(c1,c2,c3,c4,c5);

        assertTrue(m.getNbCartes() == 5);
    }

    @Test
    public void testRetirerCarte() {
        Main m = new Main();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        m.ajouterCartes(c1,c2,c3);
        m.prendreCarte(2);

        assertTrue(m.getNbCartes() == 2);
    }

    @Test
    public void testTriMain() {
        Main m = new Main();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        m.ajouterCartes(c1,c2,c3); // tri fait dans ajouterCartes

        assertTrue(m.voirCarte(0) == c3);
        assertTrue(m.voirCarte(1) == c1);
        assertTrue(m.voirCarte(2) == c2);
    }

    @Test
    public void testCasLimite() {
        Main m = new Main();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        m.ajouterCartes(c1,c2,c3); // tri directement (c'est une main)
        Carte res1 = m.voirCarte(-3);
        Carte res2 = m.voirCarte(2);
        Carte res3 = m.voirCarte(3);

        assertEquals(null,res1);
        assertEquals(c2,res2);
        assertEquals(null,res3);

        m.prendreDerniereCarte();
        m.prendreDerniereCarte();
        m.prendreDerniereCarte(); // après cela, la main est vide

        assertEquals(null,m.prendreDerniereCarte());
    }

    @Test
    public void testIterator() {
        PaquetBase m = new Main();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        m.ajouterCartes(c1,c2,c3);
        int compteur = 0;
        for (Carte c: m) {
            compteur++;;
        }
        assertEquals(3,compteur);
    }

}
