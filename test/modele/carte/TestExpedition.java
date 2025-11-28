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




}
