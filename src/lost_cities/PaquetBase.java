package lost_cities;

import java.util.*;
import java.util.stream.Stream;

abstract public class PaquetBase implements Paquet {
    private List<Carte> paquet;

    public PaquetBase() {
        this.paquet = new ArrayList<>();
    }

    protected void ajouterCartes(Carte... cartes) {
        for (Carte c: cartes) {
            this.paquet.add(c);
        }
    }
    protected void ajouterCartes(Collection<Carte> cartes) {
        for (Carte c: cartes) {
            this.paquet.add(c);
        }
    }

    protected void melanger() {
        Collections.shuffle(this.paquet);
    }

    protected void vider() {
        for (int i = 0; i< this.paquet.size(); i++) {
            this.paquet.remove(i);
        }
    }

    protected void trier() {
        this.paquet.sort(null); // ordre naturel implémenté dans Carte
    }

    protected Carte prendrePremiereCarte() {
        return this.paquet.removeFirst();
    }

    protected Carte prendreDerniereCarte() {
        return this.paquet.removeLast();
    }

    protected Carte prendreCarte(int indice) {
        return this.paquet.remove(indice);
    }


    /* Implémentation des méthodes de l'interface */

    public boolean estVide() {
        return (this.paquet.isEmpty());
    }

    public int getNbCartes() {
        return this.paquet.size();
    }

    public Carte voirCarte(int indice) {
        if (indice < 0 || indice >= this.paquet.size())
            return null;
        return this.paquet.get(indice);
    }

    public Carte voirPremiereCarte() {
        if (this.paquet.isEmpty())
            return null;
        return this.paquet.getFirst();
    }

    public Carte voirDerniereCarte() {
        if (this.paquet.isEmpty())
            return null;
        return this.paquet.getLast();
    }

    public Stream<Carte> cartes() {
        return this.paquet.stream();
    }

    public int getIndice(Carte carte) {
        return this.paquet.indexOf(carte);
    }

    public Iterator<Carte> iterator() { // car Paquet implémente Iterable<Carte>
        return this.paquet.iterator();
    }
}
