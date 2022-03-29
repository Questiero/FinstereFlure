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
    
    private final ArrayList<Jeton> jetons = new ArrayList<>();

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public Player(String name, Couleur color) {
        this.name = name;
        this.color = color;
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

}
