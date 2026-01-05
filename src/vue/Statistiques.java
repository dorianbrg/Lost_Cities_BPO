package vue;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {
    private int cartesJouees;
    private List<Integer> scoreMoyenExp = new ArrayList<>();
    private double VicBotMin;
    private double VicBotDefausse;

    public int getCartesJouees() {
        return cartesJouees;
    }

    public int getCartesDef() {
        return 44 - cartesJouees;
    }
    public List<Integer> getScoreMoyenExp() {
        return scoreMoyenExp;
    }

    public double getVicBotMin() {
        return VicBotMin;
    }

    public double getVicBotDefausse() {
        return VicBotDefausse;
    }
}
