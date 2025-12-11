package modele.carte;

public class Expedition extends PaquetCouleur {

    public Expedition(Couleur couleur) {
        super(couleur);
    }

    public boolean peutPoser(Carte carte) {
        Carte DerCarte = voirDerniereCarte();
        if (DerCarte == null) {
            return super.peutPoser(carte); // juste correspondance couleur
        }
       return super.peutPoser(carte) &&
               (carte.compareTo(DerCarte) >= 0); // correspondance couleur et valeur croissante du paquet
    }

    public int calculerScore() {
        int score = super.cartes()
                .filter(c -> c.getCouleur() == super.getCouleur())
                .mapToInt(c -> c.getCarte().getValeur())
                .sum();
        if (getNbCartes() != 0) {
            score -= 20; // prix de l'expédition
        }
        long nbPari = super.cartes()
                .filter(c -> c.getCouleur() == super.getCouleur())
                .filter(c -> c.getCarte() == TypeCarte.PARI)
                .count();
        boolean bonus = (getNbCartes() >= 8);
        if (bonus) {
            return score * (1 + (int) nbPari) + 20;
        }
        else {
            return score * (1 + (int) nbPari);
        }
    }
}
