package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import javax.swing.ImageIcon;

/**
 * Clase représentant les jetons d'un joueur
 */
public final class Jeton extends Pion implements Moveable {

    /**
     * Constructeur de Jeton en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     * @param sprite
     */
    public Jeton(Terrain terrain, int x, int y, int listIndex, ImageIcon sprite) {
        super(terrain, x, y, listIndex, sprite);
    }

    /**
     * Constructeur de Jeton en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     * @param spritePath chemin d'accès au sprite
     */
    public Jeton(Terrain terrain, int x, int y, int listIndex, String spritePath) {
        super(terrain, x, y, listIndex, spritePath);
    }

    @Override
    public void move(Direction dir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public void setX(int x) {
        this.coords[0] = x;
    }

    @Override
    public void setY(int y) {
        this.coords[1] = y;
    }

    @Override
    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

}
