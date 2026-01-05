package vue;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {
    private int cartesJouees;
    private int cartesDef;
    private List<Integer> scoreMoyenExp = new ArrayList<>();
    private double VicBotMin;
    private double VicBotDefausse;

    public int getCartesJouees() {
        return cartesJouees;
    }

    public int getCartesDef() {
        return cartesDef;
    }
    public List<Integer> getScoreMoyenExp() {
        return scoreMoyenExp;
    }

    public double getVicBotMin() {
        return VicBotMin;
    }

    public void incrCartesJouees() {
        this.cartesJouees += 1;
    }

    public void incrCartesDef() {
        this.cartesDef += 1;
    }

    public void updateScoreMoy() {

    }

    public double getVicBotDefausse() {
        return VicBotDefausse;
    }
}
