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
    
}
