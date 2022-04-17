package finstereflure.pions;

import finstereflure.Partie;
import finstereflure.enums.Direction;
import static finstereflure.enums.Direction.DOWN;
import static finstereflure.enums.Direction.LEFT;
import static finstereflure.enums.Direction.RIGHT;
import static finstereflure.enums.Direction.UP;
import finstereflure.pions.interfaces.Moveable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    public Monstre(Partie partie, int x, int y, int listIndex) {
        super(partie, x, y, listIndex, "./img/monstre2.gif");
    }

    @Override
    public void move(Direction dir) {

        LinkedList<Pion>[][] pionmap = super.terrain.getPionMap();

        pionmap[this.getX()][this.getY()].remove(this);

        switch (dir) {

            case UP:

                if ((this.getX() <= 11 && this.getY() == 0) || this.getX() == (11 + this.getY())) {
                    this.setX(15 - this.getX());
                    this.setY(10 - this.getY());
                } else {
                    this.setY(getY() - 1);
                }

                break;

            case LEFT:

                if ((this.getY() <= 6 && this.getX() == 0) || this.getY() == (6 + this.getX())) {
                    this.setX(15 - this.getX());
                    this.setY(10 - this.getY());
                } else {
                    this.setX(getX() - 1);
                }

                break;

            case RIGHT:

                if ((this.getY() >= 4 && this.getX() == 15) || this.getX() == (11 + this.getY())) {
                    this.setX(15 - this.getX());
                    this.setY(10 - this.getY());
                } else {
                    this.setX(getX() + 1);
                }

                break;

            case DOWN:

                if ((this.getX() >= 4 && this.getY() == 10) || this.getY() == (6 + this.getX())) {
                    this.setX(15 - this.getX());
                    this.setY(10 - this.getY());
                } else {
                    this.setY(getY() + 1);
                }

                break;

        }

        Pion nextPos = pionmap[this.getX()][this.getY()].getLast();

        this.terrain.getPionMap()[this.getX()][this.getY()].add(this);

        this.direction = dir;
        this.generateSprite();

        if (nextPos instanceof Hemoglobine && this.canMove(dir)) {
            this.move(dir);
        } else if (nextPos instanceof Jeton) {
            for (Pion p : pionmap[this.getX()][this.getY()]) {
                if (p instanceof Jeton) {
                    Jeton j = (Jeton) p;
                    j.die();
                }
            }
        } else if (nextPos instanceof Pierre) {
            ((Pierre) nextPos).move(dir);
        }

        this.terrain.update();

    }

    @Override
    public boolean canMove(Direction dir) {
        return true;
    }

    public Direction getTargetDirection() {
        //il faut récup les infos dans les 4 directions (joueur, pierre ou rien)
        //ensuite on les compare et on return la direction la + opti
        //si aucune direction opti : le monstre continue d'avancer dans sa direction précedante
        //penser à actualiser l'image en fonction de la direction

        HashMap<Direction, Integer> directionDistances = new HashMap<Direction, Integer>();

        Direction targetDirection = this.direction;

        int distanceFront = this.getTargetDistance(this.direction);
        if (distanceFront != -1) {
            directionDistances.put(this.direction, distanceFront);

        }

        int distanceLeft = this.getTargetDistance(this.direction.rotateLeft());
        if (distanceLeft != -1) {
            directionDistances.put(this.direction.rotateLeft(), distanceLeft);
        }

        int distanceRight = this.getTargetDistance(this.direction.rotateRight());
        if (distanceRight != -1) {
            directionDistances.put(this.direction.rotateRight(), distanceRight);

        }

        for (Map.Entry entry1 : directionDistances.entrySet()) {

            boolean min = true;

            for (Map.Entry entry2 : directionDistances.entrySet()) {
                if ((Integer) entry1.getValue() > (Integer) entry2.getValue()) {
                    min = false;
                }
            }

            if (min) {
                return (Direction) entry1.getKey();
            }

        }

        return targetDirection;

    }

    /**
     * Evalue la distance auquel est le pion à une cible
     *
     * @param dir direction dans laquelle le monstre doit estimer
     * @return distance du pion à une cible, -1 si il n'y en a pas
     */
    private int getTargetDistance(Direction dir) {

        int distance = 0;

        int targetX = this.getX();
        int targetY = this.getY();

        Pion target;

        while (targetX >= 0 && targetY >= 0 && targetX <= 15 && targetY <= 10) {

            target = this.terrain.getPionMap()[targetX][targetY].getLast();
            distance++;

            if (!(target instanceof Empty) && !(target instanceof Monstre) && !(target instanceof Hemoglobine)) {
                if (target instanceof Jeton) {
                    return distance;
                } else {
                    return -1;
                }
            }

            switch (dir) {

                case UP:
                    targetY--;
                    break;
                case LEFT:
                    targetX--;
                    break;
                case DOWN:
                    targetY++;
                    break;
                case RIGHT:
                    targetX++;
                    break;

            }

        }

        return -1;

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
