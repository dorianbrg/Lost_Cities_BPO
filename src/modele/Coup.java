package modele;

public class Coup {
    private int indCarte;
    private TypeCoup typeCoup;

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
}
