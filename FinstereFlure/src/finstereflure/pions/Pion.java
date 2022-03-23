package finstereflure.pions;

import finstereflure.Terrain;
import javax.swing.ImageIcon;

/**
 * Pion du jeu
 */
public abstract class Pion {

    private final ImageIcon sprite;
    protected final Terrain terrain;

    //Coordonnées
    private final int[] coords = new int[2];

    /**
     * Constructeur de Pion en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param sprite
     */
    public Pion(Terrain terrain, int x, int y, ImageIcon sprite) {

        this.terrain = terrain;
        this.sprite = sprite;

        this.coords[0] = x;
        this.coords[1] = y;

    }

    /**
     * Constructeur de Pion en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param spritePath chemin d'accès au sprite
     */
    public Pion(Terrain terrain, int x, int y, String spritePath) {

        this.terrain = terrain;
        this.sprite = new ImageIcon(spritePath);

        this.coords[0] = x;
        this.coords[1] = y;

    }

    public int getX() {
        return this.coords[0];
    }

    public int getY() {
        return this.coords[1];
    }
    
    /**
     * Draw le sprite du Jeton
     */
    public void draw() {
        this.terrain.getSpriteMap()[this.getX()][this.getY()].setIcon(this.sprite);
    }

}
