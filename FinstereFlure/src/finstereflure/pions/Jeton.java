package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import finstereflure.players.Player;
import javax.swing.ImageIcon;

/**
 * Clase représentant les jetons d'un joueur
 */
public final class Jeton extends Pion implements Moveable {

    private final Player player;
    private final int maxCoupsClairs;

    private boolean estClair = true;
    private int coups;

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
    public Jeton(Terrain terrain, int x, int y, int listIndex, ImageIcon sprite, Player player, int maxCoupsClairs) {
        super(terrain, x, y, listIndex, sprite);
        this.player = player;
        this.maxCoupsClairs = maxCoupsClairs;
        coups = maxCoupsClairs;
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
    public Jeton(Terrain terrain, int x, int y, int listIndex, String spritePath, Player player, int maxCoupsClairs) {
        super(terrain, x, y, listIndex, spritePath);
        this.player = player;
        this.maxCoupsClairs = maxCoupsClairs;
        coups = maxCoupsClairs;
    }

    public void flip() {

        this.estClair = !this.estClair;
        if (this.estClair) {
            this.coups = this.maxCoupsClairs;
        } else {
            this.coups = 7 - this.maxCoupsClairs;
        }

        this.generateSprite();
        
    }

    @Override
    public void move(Direction dir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canMove(Direction dir) {
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

        String s = "./img/pion" + this.player.getColor();

        s += "_" + this.maxCoupsClairs + "_" + (7 - this.maxCoupsClairs) + "_";

        if (this.estClair) {
            s += "clair";
        } else {
            s += "fonce";
        }

        s += ".gif";

        return s;

    }

}
