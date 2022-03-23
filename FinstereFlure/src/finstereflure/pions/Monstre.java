package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.pions.interfaces.Moveable;
import javax.swing.ImageIcon;

/**
 * Clase représentant le monstre
 */
public final class Monstre extends Pion implements Moveable {

    /**
     * Constructeur de Monstre en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa case
     * @param sprite
     */
    public Monstre(Terrain terrain, int x, int y, int listIndex, ImageIcon sprite) {
        super(terrain, x, y, listIndex, sprite);
    }

    /**
     * Constructeur de Monstre en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa case
     * @param spritePath chemin d'accès au sprite
     */
    public Monstre(Terrain terrain, int x, int y, int listIndex, String spritePath) {
        super(terrain, x, y, listIndex, spritePath);
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
