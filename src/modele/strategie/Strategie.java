package modele.strategie;

import modele.Coup;
import modele.carte.Couleur;

public interface Strategie {
    Coup choisitCoup(Jeu jeu);
    Couleur choisirPioche(Jeu jeu);
}
