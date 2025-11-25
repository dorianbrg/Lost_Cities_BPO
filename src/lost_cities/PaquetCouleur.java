package lost_cities;

abstract public class PaquetCouleur extends PaquetBase {
    private Couleur couleur;

    PaquetCouleur(Couleur couleur) {
        super();
        this.couleur = couleur;
    }

    public boolean peutPoser(Carte carte) {
        Carte last_carte = voirDerniereCarte();
        return last_carte.compareTo(carte) < 0;
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
