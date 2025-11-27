package modele.carte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPioche {
    @Test
    public void testInitPioche() {
        Pioche p = new Pioche();
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DEUX);
        Carte c2 = new Carte(Couleur.BLANC, TypeCarte.DEUX);
        Carte c3 = new Carte(Couleur.JAUNE, TypeCarte.PARI);

        p.ajouterCartes(c1,c2,c3);
        assertEquals(3,p.getNbCartes());

    }
}
