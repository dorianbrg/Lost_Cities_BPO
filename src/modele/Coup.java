package modele;

public class Coup {
    private final int indCarte;
    private final TypeCoup typeCoup;

    public Coup(int indice, TypeCoup type) {
        this.indCarte = indice;
        this.typeCoup = type;
    }

    public int getIndCarte() {
        return indCarte;
    }

    public TypeCoup getTypeCoup() {
        return typeCoup;
    }

    public String toString() {
        return "Coup: carte " + indCarte + " -> " + typeCoup;
    }
}
