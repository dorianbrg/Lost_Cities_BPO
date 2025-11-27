package modele.carte;

import org.junit.jupiter.api.Test;

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

        m.ajouterCartes(c1,c2,c3);
        m.trier();

        assertTrue(m.voirCarte(0) == c3);
        assertTrue(m.voirCarte(1) == c1);
        assertTrue(m.voirCarte(2) == c2);
    }

}
