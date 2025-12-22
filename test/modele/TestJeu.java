package modele;

import modele.carte.Carte;
import modele.carte.Couleur;
import modele.carte.TypeCarte;
import modele.strategie.BotMin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testCoupInvalide() { // dépend de la distribution des cartes dans la main du joueur courant
        Jeu jeu = new Jeu("nom1","nom2");
        Carte c1 = new Carte(Couleur.JAUNE, TypeCarte.DIX);
        Coup coupValide = new Coup(0,TypeCoup.JOUER);

        assertTrue(jeu.getJoueurCourant().getExpedition(Couleur.JAUNE).poser(c1));
        for(int i = 0;i < 8;i++) {
            Carte carte_i = jeu.getJoueurCourant().getMain().voirCarte(i);
            if ((carte_i.getCouleur() == Couleur.JAUNE) && (carte_i.getCarte().getValeur() < 10)) {
                Coup coupInvalide = new Coup(i,TypeCoup.JOUER);
                assertFalse(jeu.jouer(coupInvalide));
            }
        }
        assertEquals(8,jeu.getJoueurCourant().getMain().getNbCartes());
    }

    @Test
    public void testDefausse() {
        Jeu jeu = new Jeu("nom1","nom2");
        Coup coup = new Coup(0,TypeCoup.DEFAUSSER);
        Carte carteCoup = jeu.getJoueurCourant().getMain().voirCarte(0);

        assertTrue(jeu.jouer(coup));
        assertFalse(jeu.getDefausse(carteCoup.getCouleur()).estVide());
    }

    @Test
    public void testPiochePrincipal() {
        Jeu jeu = new Jeu("nom1","nom2");

        assertTrue(jeu.piocher(null));
        assertEquals(9,jeu.getJoueurCourant().getMain().getNbCartes());

    }

    @Test
    public void testPiocheDefausse() {
        Jeu jeu = new Jeu("nom1","nom2");
        Coup coup = new Coup(0,TypeCoup.DEFAUSSER);
        Carte carteJoue = jeu.getJoueurCourant().getMain().voirCarte(0);

        assertTrue(jeu.getDefausse(carteJoue.getCouleur()).estVide());
        assertTrue(jeu.jouer(coup));
        assertFalse(jeu.getDefausse(carteJoue.getCouleur()).estVide());
        assertTrue(jeu.piocher(carteJoue.getCouleur()));
    }

    @Test
    public void testJoueurSuiv() {
        Jeu jeu = new Jeu("nom1","nom2");

        assertEquals(jeu.getJoueur(0),jeu.getJoueurCourant());

        jeu.passerJoueurSuivant();

        assertEquals(jeu.getJoueur(1),jeu.getJoueurCourant());
    }

    @Test
    public void testFin() {
        Jeu jeu = new Jeu("nom1","nom2");

        assertFalse(jeu.estFini());

        while (!(jeu.getPioche().estVide())) {
            jeu.piocher(null);
        }

        assertTrue(jeu.estFini());
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu("Bot1","Bot2");
        // Configurer les strategies des joueurs
        jeu.getJoueur(0).setStrategie(new BotMin());
        jeu.getJoueur(1).setStrategie(new BotMin());
        while (!jeu.estFini()) {
            Joueur joueur = jeu.getJoueurCourant();

            Coup coup = joueur.choisirCoup(jeu);
            jeu.jouer(coup);

            Couleur pioche = joueur.choisirPioche(jeu);
            jeu.piocher(pioche);

            System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.JAUNE));
            System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.BLEU));
            System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.BLANC));
            System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.ROUGE));
            System.out.println(jeu.getJoueurCourant().getExpedition(Couleur.VERT));
            System.out.println(jeu.getPioche().getNbCartes());

            jeu.passerJoueurSuivant();

        }
        // Afficher les scores finaux
        System.out.println("Score joueur 0 : " +
                jeu.getJoueur(0).getScore());
        System.out.println("Score joueur 1 : " +
                jeu.getJoueur(1).getScore());
    }

}
