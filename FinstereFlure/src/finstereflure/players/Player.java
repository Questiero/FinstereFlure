package finstereflure.players;

import finstereflure.enums.PlayerType;
import finstereflure.enums.Couleur;
import finstereflure.pions.Jeton;
import java.util.ArrayList;

/**
 * Joueur
 */
public abstract class Player {

    private final String name;
    private final Couleur color;

    private final int maxJetons;
    private final ArrayList<Jeton> jetons = new ArrayList<>();
    private final ArrayList<Jeton> jetonsWon = new ArrayList<>();

    private int jetonsPlayed = 0;

    /**
     * Constructeur de Player
     *
     * @param name nom du joueur
     * @param color Couleur du joueur
     */
    public Player(String name, Couleur color) {

        this.name = name;
        this.color = color;

        this.maxJetons = color.getMaxJetons();

    }

    public int getMaxJetons() {
        return maxJetons;
    }

    @Override
    public String toString() {

        return ("Name : " + this.name
                + "\tCouleur : " + this.color
                + "\tType : " + this.getType());
    }

    public abstract PlayerType getType();

    public String getName() {
        return this.name;
    }

    public Couleur getColor() {
        return this.color;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public ArrayList<Jeton> getJetonsWon() {
        return jetonsWon;
    }

    public int getJetonsPlayed() {
        return jetonsPlayed;
    }

    public void addJetonsPlayed() {
        this.jetonsPlayed++;
    }

    public void resetJetonsPlayed() {
        this.jetonsPlayed = 0;
    }

    public boolean canWin() {
        //return (this.jetons.size() - this.jetonsWon.size()) == 1;
        return (this.jetonsWon.size()) == 3;

    }

}
