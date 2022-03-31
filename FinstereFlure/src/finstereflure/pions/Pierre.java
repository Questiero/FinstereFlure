package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import javax.swing.ImageIcon;

public final class Pierre extends Pion implements Moveable {

    /**
     * Constructeur de Pierre en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     */
    public Pierre(Terrain terrain, int x, int y, int listIndex) {
        super(terrain, x, y, listIndex, "./img/mur.png");
    }

    @Override
    public void move(Direction dir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(Direction dir) {
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

    @Override
    public String generateSpritePath() {
        return "./img/mur.png";
    }

}
