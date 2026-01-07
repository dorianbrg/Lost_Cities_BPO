package modele.strategie;

import modele.Coup;
import modele.Jeu;
import modele.carte.Couleur;

public interface Strategie {
    Coup choisirCoup(Jeu jeu);
    Couleur choisirPioche(Jeu jeu);
    String getStrategie(); // Méthode qui permet de transmettre l'information de la stratégie utilisée
}
