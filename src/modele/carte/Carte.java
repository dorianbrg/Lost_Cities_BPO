package modele.carte;

import java.util.Comparator;

public class Carte implements Comparable<Carte> {
    private final Couleur couleur;
    private final TypeCarte carte;

    public Carte(Couleur couleur, TypeCarte carte) {
        this.couleur = couleur;
        this.carte = carte;
    }

    private static final Comparator<Carte> COMP =
            Comparator.comparing(Carte::getCouleur)
                    .thenComparingInt(c -> c.getCarte().getValeur());

    // Comparateur par valeur uniquement, utilisé pour BotMin essentiellement
    public static final Comparator<Carte> COMP_VAL =
            Comparator.comparingInt(c -> c.getCarte().getValeur());

    // Comparaison pour l'ordre naturel
    @Override
    public int compareTo(Carte autre) { // pour l'ordre naturel comme la classe implémente Comparable<Carte>
        return COMP.compare(this,autre);
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public TypeCarte getCarte() {
        return carte;
    }

    public String toString() {
        String res = this.carte.getValeur() + " " + this.couleur;
        return this.couleur.txt(res);
    }
}
