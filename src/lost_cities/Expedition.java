package lost_cities;

public class Expedition extends PaquetCouleur {

    public Expedition(Couleur couleur) {
        super(couleur);
    }

    public boolean peutPoserCarte(Carte carte) {
       return super.peutPoser(carte) &&
               (carte.compareTo(voirDerniereCarte()) >= 0); // correspondance couleur et valeur croissante du paquet
    }

    int calculerScore() {
        int score = super.cartes()
                .filter(c -> c.getCouleur() == super.getCouleur())
                .mapToInt(c -> c.getCarte().getValeur())
                .sum();
        long nbPari = super.cartes()
                .filter(c -> c.getCouleur() == super.getCouleur())
                .filter(c -> c.getCarte() == TypeCarte.PARI)
                .count();

        return score * (1 + (int) nbPari);
    }
}
