package finstereflure.players;

import finstereflure.Couleur;

/**
 * Joueur
 */
public abstract class Player {

    private final String name;
    private final Couleur color;

    public Player(String name, Couleur color) {
        this.name = name;
        this.color = color;
    }
<<<<<<< Updated upstream

    @Override
    public String toString() {

        return ("Name : " + this.name
                + "\tCouleur : " + this.color
                + "\tType : " + this.getType());
    }

    public String getNamePlayer() {
        return name;
    }

    public Couleur getColor() {
        return color;
    }

    public abstract PlayerType getType();

=======
    
    public String getName() {
        return this.name;
    }
    
    public Couleur getColor() {
        return this.color;
    }
    
>>>>>>> Stashed changes
}
