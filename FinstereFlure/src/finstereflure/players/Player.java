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

    public Player(String name, Couleur color) {
        this.name = name;
        this.color = color;

        switch (color) {
            case BLUE, GREEN, RED, YELLOW:
                this.maxJetons = 4;
                break;
            case BROWN, PURPLE, GRAY:
                this.maxJetons = 3;
                break;
            default:
                this.maxJetons = 0;
        }

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

    public boolean canWin() {
        return (this.jetons.size() - this.jetonsWon.size()) == 1;
    }

}
