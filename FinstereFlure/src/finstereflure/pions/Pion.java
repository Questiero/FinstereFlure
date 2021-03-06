package finstereflure.pions;

import finstereflure.Partie;
import finstereflure.Terrain;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * Pion du jeu
 */
public abstract class Pion {

    protected ImageIcon sprite;
    protected final Partie partie;
    protected final Terrain terrain;

    //Coordonnées
    protected final int[] coords = new int[2];

    /**
     * Constructeur de Pion en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param sprite
     */
    public Pion(Partie partie, int x, int y, ImageIcon sprite) {

        this.partie = partie;
        this.terrain = partie.getTerrain();
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
    public Pion(Partie partie, int x, int y, String spritePath) {

        this.partie = partie;
        this.terrain = partie.getTerrain();
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

    public void generateSprite() {
        this.sprite = new ImageIcon(this.generateSpritePath());
        this.terrain.update();
    }

    public abstract String generateSpritePath();

}
