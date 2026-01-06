package modele.carte;

public enum Couleur {
    JAUNE("\u001B[33m"), BLANC("\u001B[37m"), BLEU("\u001B[34m"), VERT("\u001B[32m"), ROUGE("\u001B[31m");

    private final String code;
    private static final String RESET = "\u001B[0m";

    Couleur(String code) {
        this.code = code;
    }

    public String txt(String message) {
        return code + message + RESET;
    }
}
