package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import java.util.LinkedList;
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

        LinkedList<Pion>[][] pionmap = super.terrain.getPionMap();

        pionmap[this.getX()][this.getY()].remove(this);

        switch (dir) {
            case UP:
                this.setY(getY() - 1);
                break;
            case LEFT:
                this.setX(getX() - 1);
                break;
            case RIGHT:
                this.setX(getX() + 1);
                break;
            case DOWN:
                this.setY(getY() + 1);
                break;
        }

        Pion nextPos = pionmap[this.getX()][this.getY()].getLast();

        if (!((this.getX() == 0 && this.getY() == 0) || (this.getX() == 15 && this.getY() == 10))) {
            pionmap[this.getX()][this.getY()].add(this);

        }

        if (nextPos instanceof Hemoglobine && this.canMove(dir)) {
            this.move(dir);
        }

        this.terrain.update();
    }

    @Override
    public boolean canMove(Direction dir) {

        LinkedList<Pion>[][] pionmap = new LinkedList[16][11];
        pionmap = super.terrain.getPionMap();

        Pion nextPos;   //donne dans chaque direction l'occupant de la case (après traitement)
        Pion befPos;    //position du pion qui pousse la pierre (jeton ou monstre)

        switch (dir) {
            case UP:

                befPos = pionmap[this.getX()][this.getY() + 1].getLast();
                
                if (befPos instanceof Jeton) {   //cas du jeton qui pousse la pierre

                    if (this.getY() == 0) {
                        return false;
                    }

                    if ((this.getX() == 12 && this.getY() == 1) || (this.getX() == 13 && this.getY() == 2)
                            || //cas de "l'escalier" en haut à droite
                            (this.getX() == 14 && this.getY() == 3) || (this.getX() == 15 && this.getY() == 4)) {
                        return false;

                    }

                    nextPos = pionmap[this.getX()][this.getY() - 1].getLast();

                    if (nextPos instanceof Jeton) {   //cas où il y a un jeton joueur                    
                        return false;
                    }

                } else if (befPos instanceof Monstre) {
                    return true;
                }

                break;

            case LEFT:

                befPos = pionmap[this.getX() + 1][this.getY()].getLast();

                if (befPos instanceof Jeton) {   //cas du jeton qui pousse la pierre
                    if (this.getX() == 0) {
                        return false;
                    }

                    if ((this.getX() == 1 && this.getY() == 7) || (this.getX() == 2 && this.getY() == 8)
                            || //escalier en bas à gauche
                            (this.getX() == 3 && this.getY() == 9) || (this.getX() == 4 && this.getY() == 10)) {
                        return false;
                    }

                    nextPos = pionmap[this.getX() - 1][this.getY()].getLast();

                    if (nextPos instanceof Jeton) {   //cas où il y a un jeton joueur
                        return false;
                    }
                } else if (befPos instanceof Monstre) {
                    return true;
                }
                break;

            case RIGHT:

                befPos = pionmap[this.getX() - 1][this.getY()].getLast();

                if (befPos instanceof Jeton) {   //cas du jeton qui pousse la pierre
                    if (this.getX() == 15) {
                        return false;
                    }

                    if ((this.getX() == 14 && this.getY() == 3) || (this.getX() == 13 && this.getY() == 2)
                            || (this.getX() == 12 && this.getY() == 1) || (this.getX() == 11 && this.getY() == 0)) {
                        return false;

                    }

                    nextPos = pionmap[this.getX() + 1][this.getY()].getLast();

                    if (nextPos instanceof Jeton) {   //cas où il y a un jeton joueur
                        return false;
                    }

                } else if (befPos instanceof Monstre) {
                    return true;
                }
                break;

            case DOWN:
                
                befPos = pionmap[this.getX()][this.getY() - 1].getLast();

                if (befPos instanceof Jeton) {   //cas du jeton qui pousse la pierre
                    if (this.getY() == 10) {
                        return false;
                    }

                    if ((this.getX() == 3 && this.getY() == 9) || (this.getX() == 2 && this.getY() == 8)
                            || (this.getX() == 1 && this.getY() == 7) || (this.getX() == 0 && this.getY() == 6)) {
                        return false;

                    }

                    nextPos = pionmap[this.getX()][this.getY() + 1].getLast();

                    if (nextPos instanceof Jeton) {   //cas où il y a un jeton joueur
                        return false;
                    }
                } else if (befPos instanceof Monstre) {
                    return true;
                }
                break;

        }

        return true;

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
        return "./img/mur.png";
    }

}
