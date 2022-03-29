package finstereflure.pions;

import finstereflure.Terrain;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * Pion du jeu
 */
public abstract class Pion {

    protected ImageIcon sprite;
    protected final Terrain terrain;

    //Coordonnées
    protected final int[] coords = new int[2];
    protected int listIndex;

    /**
     * Constructeur de Pion en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     * @param sprite
     */
    public Pion(Terrain terrain, int x, int y, int listIndex, ImageIcon sprite) {

        this.terrain = terrain;
        this.sprite = sprite;

        this.coords[0] = x;
        this.coords[1] = y;

        this.listIndex = listIndex;

    }

    /**
     * Constructeur de Pion en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     * @param spritePath chemin d'accès au sprite
     */
    public Pion(Terrain terrain, int x, int y, int listIndex, String spritePath) {

        this.terrain = terrain;
        this.sprite = new ImageIcon(spritePath);

        this.coords[0] = x;
        this.coords[1] = y;

        this.listIndex = listIndex;

    }

    public int getX() {
        return this.coords[0];
    }

    public int getY() {
        return this.coords[1];
    }

    public int getListIndex() {
        return this.listIndex;
    }

    /**
     * Draw le sprite du Jeton
     */
    public void draw() {
        this.terrain.getSpriteMap()[this.getX()][this.getY()].setIcon(this.sprite);
    }

    protected LinkedList<Pion> getTile() {
        return this.terrain.getPionMap()[this.coords[0]][this.coords[1]];
    }

}
