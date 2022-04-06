package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import static finstereflure.enums.Direction.DOWN;
import static finstereflure.enums.Direction.LEFT;
import static finstereflure.enums.Direction.RIGHT;
import static finstereflure.enums.Direction.UP;
import finstereflure.pions.interfaces.Moveable;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * Clase représentant le monstre
 */
public final class Monstre extends Pion implements Moveable {

    private Direction direction = Direction.RIGHT;

    /**
     * Constructeur de Monstre en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param listIndex indice du Pion dans la LinkedList correspondant à sa
     * case
     */
    public Monstre(Terrain terrain, int x, int y, int listIndex) {
        super(terrain, x, y, listIndex, "./img/monstre2.gif");
    }

    @Override
    public void move(Direction dir) {

        this.terrain.getPionMap()[this.getX()][this.getY()].remove(this);

        switch (dir) {
            case UP:
                if (this.getY() == 0) {
                    this.setY(10);
                } else {
                    this.setY(getY() - 1);
                }
                break;
            case LEFT:
                if (this.getX() == 0) {
                    this.setX(15);
                } else {
                    this.setX(getX() - 1);
                }
                break;
            case RIGHT:
                if (this.getX() == 15) {
                    this.setX(0);
                } else {
                    this.setX(getX() + 1);
                }
                break;
            case DOWN:
                if (this.getY() == 10) {
                    this.setY(0);
                } else {
                    this.setY(getY() + 1);
                }
                break;
        }

        this.terrain.getPionMap()[this.getX()][this.getY()].add(this);
        this.listIndex = this.terrain.getPionMap()[this.getX()][this.getY()].size();

        this.terrain.update();
    }

    @Override
    public boolean canMove(Direction dir) {
        return true;
    }

    public Direction targetDirection() {
        //il faut récup les infos dans les 4 directions (joueur, pierre ou rien)
        //ensuite on les compare et on return la direction la + opti
        //si aucune direction opti : le monstre continue d'avancer dans sa direction précedante
        //penser à actualiser l'image en fonction de la direction

        LinkedList<Pion>[][] pionmap = new LinkedList[16][11];
        pionmap = super.terrain.getPionMap();

        Pion nextPosUP = pionmap[this.getX()][this.getY() - 1].getLast();
        Pion nextPosLEFT = pionmap[this.getX() - 1][this.getY()].getLast();
        Pion nextPosRIGHT = pionmap[this.getX() + 1][this.getY()].getLast();
        Pion nextPosDOWN = pionmap[this.getX()][this.getY() + 1].getLast();

        Pion[] tabNextPos = new Pion[]{nextPosUP, nextPosLEFT, nextPosRIGHT, nextPosDOWN};

        boolean found = false;  //passe à vrai si on trouve un pion différent de Empty
        int indiceDirection = 0;

        boolean isSmthArround = false;  //test si on agrandit la recherche

        while (!isSmthArround) {
            
            nextPosUP = pionmap[this.getX()][this.getY() - 1].getLast();
        nextPosLEFT = pionmap[this.getX() - 1][this.getY()].getLast();
        nextPosRIGHT = pionmap[this.getX() + 1][this.getY()].getLast();
        nextPosDOWN = pionmap[this.getX()][this.getY() + 1].getLast();

            for (int i = 0; i < tabNextPos.length; i++) {
                if (tabNextPos[i] instanceof Empty) {
                } else {
                    found = true;
                    indiceDirection = i;   //si deux joueurs à la même distance, il ira vers le dernier vu
                }
            }

            if (found) {
                switch (indiceDirection) {
                    case 0:
                        this.direction = UP;
                        break;

                    case 1:
                        this.direction = LEFT;
                        break;

                    case 2:
                        this.direction = RIGHT;
                        break;

                    case 3:
                        this.direction = DOWN;
                        break;
                }

            }
        }
        return this.direction;  //A CHANGER
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

        String s = "./img/monstre";

        switch (this.direction) {
            case UP:
                s += "1";
                break;
            case RIGHT:
                s += "2";
                break;
            case DOWN:
                s += "3";
                break;
            case LEFT:
                s += "4";
                break;

        }

        return s += ".gif";

    }

}
