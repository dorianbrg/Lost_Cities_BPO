package lost_cities;

public class Carte implements Comparable<Carte> {
    private Couleur couleur;
    private TypeCarte carte;

    public Carte(Couleur couleur, TypeCarte carte) {
        this.couleur = couleur;
        this.carte = carte;
    }

    @Override
    public int compareTo(Carte autre) {
        return Integer.compare(this.carte.getValeur(),autre.carte.getValeur());
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public TypeCarte getCarte() {
        return carte;
    }
}
