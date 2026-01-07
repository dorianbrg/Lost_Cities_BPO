package modele.carte;

abstract public class PaquetCouleur extends PaquetBase {
    private final Couleur couleur;

    public PaquetCouleur(Couleur couleur) {
        super();
        this.couleur = couleur;
    }

    // La méthode vérifie ici si la carte en arugment est de la même couleur que le paquet. Les sous-classes la redéfinissent.
    public boolean peutPoser(Carte carte) {
        return carte.getCouleur() == couleur;
    }

    public boolean poser(Carte carte) {
       if (peutPoser(carte)) {
           super.ajouterCartes(carte);
           return true;
        }
       return false;
    }

    public Couleur getCouleur() {
        return couleur;
    }

}
