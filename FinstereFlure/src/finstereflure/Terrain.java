package finstereflure;

import finstereflure.pions.Empty;
import finstereflure.pions.Pion;
import javax.swing.JLabel;

/**
 * Terrain de jeu
 */
public class Terrain {

    private Pion[][] pionMap;
    private JLabel[][] spriteMap;

    /**
     * Constructeur de Terrain avec dimensions classiques
     */
    public Terrain() {
        this.pionMap = new Pion[16][11];
        this.spriteMap = new JLabel[16][11];
    }

    /**
     * Constructeur de Terrain avec dimensions personnalisées
     *
     * @param x largeur du terrain
     * @param y hauteur du terrain
     */
    public Terrain(int x, int y, boolean isAdvanced) {
        this.pionMap = new Pion[x][y];
        this.spriteMap = new JLabel[x][y];
    }

    /**
     * Initialisation du terrain
     *
     * @param isAdvanced
     */
    public void init(boolean isAdvanced) {

        for (int i = 0; i < this.pionMap.length; i++) {
            for (int j = 0; j < this.pionMap[i].length; j++) {
                this.pionMap[i][j] = new Empty(this, i, j);
            }
        }

        if (!isAdvanced) {

            //TODO
        } else {

            //TODO
        }

    }

    public Pion[][] getPionMap() {
        return this.pionMap;
    }

    public JLabel[][] getSpriteMap() {
        return this.spriteMap;
    }

    /**
     * Redraw tout les sprites du terrain
     */
    public void update() {
        for(Pion[] array : this.pionMap) {
            for(Pion p : array) {
                p.draw();
            }
        }
    }
    
}
