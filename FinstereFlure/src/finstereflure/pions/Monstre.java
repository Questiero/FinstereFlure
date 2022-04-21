package finstereflure.pions;

import finstereflure.Partie;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clase représentant le monstre
 */
public final class Monstre extends Pion implements Moveable {

    private Direction direction = Direction.RIGHT;

    private int victimes = 0;
    private int pas = 0;

    /**
     * Constructeur de Monstre en fonction d'un ImageIcon pour sprite
     *
     * @param Partie référence de la partie
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     */
    public Monstre(Partie partie, int x, int y) {
        super(partie, x, y, "./img/monstre2.gif");
    }

    /**
     *
     * @return
     */
    public int getVictimes() {
        return victimes;
    }

    public void setVictimes(int victimes) {
        this.victimes = victimes;
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    /**
     * Permet de déplacer le Monstre dans une Direction
     *
     * @param dir direction vers laquelle le Monstre sera déplacé
     */
    @Override
    public void move(Direction dir) {

        this.pas++;

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

        if (nextPos instanceof Hemoglobine && this.canMove(dir)) {
            this.move(dir);
        } else if (nextPos instanceof Jeton) {

            ArrayList<Jeton> toDie = new ArrayList<>();

            for (Pion p : pionmap[this.getX()][this.getY()]) {

                if (p instanceof Jeton) {

                    this.victimes++;

                    Jeton j = (Jeton) p;
                    toDie.add(j);

                }
            }

            for (Jeton j : toDie) {

                j.die();

                if (this.partie.getManche() == 1) {
                    j.revive();
                }

            }

        } else if (nextPos instanceof Pierre) {
            ((Pierre) nextPos).move(dir);
        }

        this.direction = this.getTargetDirection();
        this.generateSprite();
        this.terrain.update();

    }

    @Override
    public boolean canMove(Direction dir) {
        return true;
    }

    public Direction getTargetDirection() {

        // HashMap assotiant chaque direction à la distance entre le monstre et le Jeton le plus proche dans celle-ci
        HashMap<Direction, Integer> directionDistances = new HashMap<Direction, Integer>();

        Direction targetDirection = this.direction;

        // Récupération de la distance entre le monstre et le Jeton le plus proche devant lui
        int distanceFront = this.getTargetDistance(this.direction);
        if (distanceFront != -1) {
            directionDistances.put(this.direction, distanceFront);
        }

        // Récupération de la distance entre le monstre et le Jeton le plus proche à gauche
        int distanceLeft = this.getTargetDistance(this.direction.rotateLeft());
        if (distanceLeft != -1) {
            directionDistances.put(this.direction.rotateLeft(), distanceLeft);
        }

        // Récupération de la distance entre le monstre et le Jeton le plus proche à droite
        int distanceRight = this.getTargetDistance(this.direction.rotateRight());
        if (distanceRight != -1) {
            directionDistances.put(this.direction.rotateRight(), distanceRight);

        }

        // Traitement sur la HashMap afin d'obtenir la plus petite distance
        for (Map.Entry entry1 : directionDistances.entrySet()) {

            boolean min = true;

            for (Map.Entry entry2 : directionDistances.entrySet()) {
                if ((Integer) entry1.getValue() > (Integer) entry2.getValue()) {
                    min = false;
                } else if ((Integer) entry1.getValue() == (Integer) entry2.getValue() && entry1.getKey() != entry2.getKey()) {
                    // Si deux distances égales, le monstre est confus et avance tout droit
                    return this.direction;
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

        // Augmentation petit à petit de la distance par rapport au Monstre tant qu'on reste dans les bornes du terrain
        while (targetX >= 0 && targetY >= 0 && targetX <= 15 && targetY <= 10) {

            target = this.terrain.getPionMap()[targetX][targetY].getLast();
            distance++;

            if (!(target instanceof Empty) && !(target instanceof Monstre) && !(target instanceof Hemoglobine)) {
                if (target instanceof Jeton) {
                    // Si on trouve un Jeton, on s'arrête là
                    return distance;
                } else {
                    // Si on trouve une Pierre, on ne trouve rien
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
