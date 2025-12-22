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

    public static final Comparator<Carte> COMP_VAL =
            Comparator.comparingInt(c -> c.getCarte().getValeur());

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
        if (this.couleur == Couleur.JAUNE) {
            return "\u001B[33m" + res + "\u001B[0m";
        }
        if (this.couleur == Couleur.BLEU) {
            return "\u001B[34m" + res + "\u001B[0m";
        }
        if (this.couleur == Couleur.ROUGE) {
            return "\u001B[31m" + res + "\u001B[0m";
        }
        if (this.couleur == Couleur.BLANC) {
            return "\u001B[37m" + res + "\u001B[0m";
        }
        if (this.couleur == Couleur.VERT) {
            return "\u001B[32m" + res + "\u001B[0m";
        }
        return res;
    }
}
