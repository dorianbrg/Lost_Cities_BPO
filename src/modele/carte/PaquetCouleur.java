package modele.carte;

abstract public class PaquetCouleur extends PaquetBase {
    private final Couleur couleur;

    PaquetCouleur(Couleur couleur) {
        super();
        this.couleur = couleur;
    }

    public boolean peutPoser(Carte carte) {
        return carte.getCouleur() == couleur;
    }

    public boolean poser(Carte carte) {
       if (peutPoser(carte)) {
           ajouterCartes(carte);
           return true;
        }
       return false;
    }

    public Couleur getCouleur() {
        return couleur;
    }

}
