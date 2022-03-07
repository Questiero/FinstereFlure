package finstereflure;

import finstereflure.pions.Empty;
import finstereflure.pions.Pion;

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
        
        for(int i = 0; i<this.map.length; i++) {
            for(int j = 0; j<this.map[i].length; j++) {
                this.map[i][j] = new Empty();
            }
        }
        
    }
    
}
