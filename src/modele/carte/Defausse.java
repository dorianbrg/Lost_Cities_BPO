package modele.carte;

public class Defausse extends PaquetCouleur implements Piochable {

    public Defausse(Couleur couleur) {
        super(couleur);
    }

    public Carte prendreCarte() {
        return prendreDerniereCarte(); // les défausses sont face à nous, qd on pioche dans la défausse il s'agit de la dernière carte
    }

}
