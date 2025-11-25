package lost_cities;

public enum TypeCarte {
    PARI(0), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10);

    private final int valeur;

    TypeCarte(int valeur) {
        this.valeur = valeur;
    }

    int getValeur() {
        return valeur;
    }
}
