package modele.carte;

public enum Couleur {
    JAUNE("\u001B[33m"), BLANC("\u001B[37m"), BLEU("\u001B[34m"), VERT("\u001B[32m"), ROUGE("\u001B[31m");

    private final String code; // code pour afficher le texte en couleur en fonction de la oculeur de la carte
    private static final String RESET = "\u001B[0m"; // code pour reset la couleur par défaut pour l'affichage

    Couleur(String code) {
        this.code = code;
    }

    // Méthode pour afficher un message en couleur pour l'ergonomie du jeu
    public String txt(String message) {
        return code + message + RESET;
    }
}
