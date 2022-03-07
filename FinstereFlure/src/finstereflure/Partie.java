package finstereflure;

import finstereflure.players.Player;

/**
 * Gestion d'une partie de jeu
 */
public class Partie {
    
    private final Host host;
    
    private Player[] players = new Player[2];
    private Terrain map;
    
    private boolean advancedMode = false;
    
    /**
     * Constructeur de Partie en fonction de son hôte
     * 
     * @param host Hôte de la partie
     */
    public Partie(Host host) {
        this.host = host;
    }
    
    
    
}
