package finstereflure;

import finstereflure.pions.Pion;
import finstereflure.players.Player;

public class Partie {
    
    private final String hostName;
    
    private Player[] players = new Player[2];
    private Map map;
    
    private boolean advancedMode = false;
    
    public Partie(String hostName) {
        this.hostName = hostName;
    }
    
}
