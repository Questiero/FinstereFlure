package finstereflure.pions;

import finstereflure.Terrain;
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
     * @param sprite
     */
    public Jeton(Terrain terrain, int x, int y, ImageIcon sprite) {
        super(terrain, x, y, sprite);
    }

    /**
     * Constructeur de Jeton en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param spritePath chemin d'accès au sprite
     */
    public Jeton(Terrain terrain, int x, int y, String spritePath) {
        super(terrain, x, y, spritePath);
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
