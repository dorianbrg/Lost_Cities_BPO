package modele.carte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExpedition {

    @Test
    public void testExpeditionOrdreValide() {
        Expedition exp = new Expedition(Couleur.ROUGE);
        Carte pari = new Carte(Couleur.ROUGE, TypeCarte.PARI);
        Carte deux = new Carte(Couleur.ROUGE, TypeCarte.DEUX);
        Carte cinq = new Carte(Couleur.ROUGE, TypeCarte.CINQ);

        assertTrue(exp.poser(pari));
        assertTrue(exp.poser(deux));
        assertTrue(exp.poser(cinq));
        assertEquals(3, exp.getNbCartes());
    }

    @Test
    public void testPariApresChiffre() {
        Expedition exp = new Expedition(Couleur.ROUGE);
        Carte pari = new Carte(Couleur.ROUGE, TypeCarte.PARI);
        Carte deux = new Carte(Couleur.ROUGE, TypeCarte.DEUX);

        assertTrue(exp.poser(deux));
        assertFalse(exp.poser(pari));
        assertEquals(1, exp.getNbCartes());
    }

    @Test
    public void testPoserCarteDesordre() {
        Expedition exp = new Expedition(Couleur.ROUGE);
        Carte pari = new Carte(Couleur.ROUGE, TypeCarte.PARI);
        Carte deux = new Carte(Couleur.ROUGE, TypeCarte.DEUX);
        Carte cinq = new Carte(Couleur.ROUGE, TypeCarte.CINQ);

        assertTrue(exp.poser(pari));
        assertTrue(exp.poser(cinq));
        assertFalse(exp.poser(deux));
        assertEquals(2, exp.getNbCartes());
    }

    @Test
    public void testPoserMauvaiseCouleur() {
        Expedition exp = new Expedition(Couleur.ROUGE);
        Carte pari = new Carte(Couleur.ROUGE, TypeCarte.PARI);
        Carte deux = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte cinq = new Carte(Couleur.ROUGE, TypeCarte.CINQ);

        assertTrue(exp.poser(pari));
        assertFalse(exp.poser(deux));
        assertTrue(exp.poser(cinq));
        assertEquals(2, exp.getNbCartes());
    }

    @Test
    public void testScoreVide() {
        Expedition exp = new Expedition(Couleur.ROUGE);

        assertEquals(0, exp.calculerScore());
    }

    @Test
    public void testScoreParis() {
        Expedition exp = new Expedition(Couleur.ROUGE);
        Carte pari = new Carte(Couleur.ROUGE, TypeCarte.PARI);

        exp.poser(pari);

        assertEquals(-40, exp.calculerScore());
    }

    @Test
    public void testExpeditionScoreSimple() {
        Expedition exp = new Expedition(Couleur.BLEU);
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.CINQ));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.DIX));
        // (5 + 10 - 20) * 1 = -5
        assertEquals(-5, exp.calculerScore());
    }

    @Test
    public void testScoreMultiplication() {
        Expedition exp = new Expedition(Couleur.BLEU);
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.PARI));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.CINQ));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.DIX));
        // (5 + 10 - 20) * 2 = -10
        assertEquals(-10, exp.calculerScore());
    }

    @Test
    public void testScoreBonus() {
        Expedition exp = new Expedition(Couleur.BLEU);
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.DEUX));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.TROIS));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.QUATRE));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.CINQ));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.SIX));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.SEPT));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.HUIT));
        exp.poser(new Carte(Couleur.BLEU, TypeCarte.NEUF));
        // ( 2+3+4+5+6+7+8+9 - 20) + 20 = 34
        assertEquals(44, exp.calculerScore());
    }
    // Fin de la classe de Test et du TP2
}
