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
    }
    
    /**
     * Constructeur de Terrain avec dimensions personnalisées
     * 
     * @param x largeur du terrain
     * @param y hauteur du terrain
     */
    public Terrain(int x, int y, boolean isAdvanced) {
        this.map = new Pion[x][y];
    }

    /**
     * Initialisation du terrain
     * 
     * @param isAdvanced
     */
    public void init(boolean isAdvanced) {
        
        for(int i = 0; i<this.map.length; i++) {
            for(int j = 0; j<this.map[i].length; j++) {
                this.map[i][j] = new Empty(this, i, j);
            }
        }
        
        if(!isAdvanced) {
            
            //TODO
            
        } else {
            
            //TODO
            
        }
        
    }
    
    
    
}
