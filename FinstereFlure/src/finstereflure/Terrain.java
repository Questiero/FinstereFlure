package finstereflure;

import finstereflure.pions.Pion;
import java.util.Arrays;

/**
 * Terrain de jeu
 */
public class Terrain {
    
    private Pion[][] map;
    
    /**
     * Constructeur de Terrain avec dimensions classiques
     */
    public Terrain() {
        this.map = new Pion[16][11];
        this.init();
    }
    
    /**
     * Constructeur de Terrain avec dimensions personnalisées
     * 
     * @param x largeur du terrain
     * @param y hauteur du terrain
     */
    public Terrain(int x, int y) {
        this.map = new Pion[x][y];
        this.init();
    }

    /**
     * Initialisation du terrain
     */
    private void init() {
        
        Arrays.fill(map, null);
        
    }
    
}
