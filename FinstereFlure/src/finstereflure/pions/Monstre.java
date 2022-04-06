package finstereflure.pions;

import finstereflure.Terrain;
import finstereflure.enums.Direction;
import static finstereflure.enums.Direction.DOWN;
import static finstereflure.enums.Direction.LEFT;
import static finstereflure.enums.Direction.RIGHT;
import static finstereflure.enums.Direction.UP;
import finstereflure.pions.interfaces.Moveable;
import java.util.ArrayList;
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

        Pion nextPosUP = pionmap[this.getX()][this.getY()].getLast();       //initialisation à la position actuelle du monstre car modification dans la boucle while
        Pion nextPosLEFT = pionmap[this.getX()][this.getY()].getLast();
        Pion nextPosRIGHT = pionmap[this.getX()][this.getY()].getLast();
        Pion nextPosDOWN = pionmap[this.getX()][this.getY()].getLast();

        //Pion[] tabNextPos = new Pion[]{nextPosUP, nextPosLEFT, nextPosRIGHT, nextPosDOWN};  //tableau contenant les positions suivantes
        ArrayList listNextPos = new ArrayList();
        listNextPos.add(nextPosUP);
        listNextPos.add(nextPosLEFT);
        listNextPos.add(nextPosRIGHT);
        listNextPos.add(nextPosDOWN);

        //boolean found = false;  //passe à vrai si on trouve un pion différent de Empty
        int indiceDirection = 0;    //permet de définir la direction du pion trouvé

        boolean isSmthArround = false;  //test si on agrandit la recherche, si le monstre voit un jeton ou non

        while (!isSmthArround && !listNextPos.isEmpty()) {            //tant que le monstre ne 'voit' pas de jeton et que la liste de positions suivantes n'est pas vide

            nextPosUP = pionmap[this.getX()][this.getY() - 1].getLast();    //changement de la position à la position suivante
            nextPosLEFT = pionmap[this.getX() - 1][this.getY()].getLast();
            nextPosRIGHT = pionmap[this.getX() + 1][this.getY()].getLast();
            nextPosDOWN = pionmap[this.getX()][this.getY() + 1].getLast();

            
            for (int i = 0; i < listNextPos.size(); i++) {   //pour chaque position suivante autour du monstre

                //si on atteint une case à l'extérieur de la carte, qui n'existe pas, on l'enlève de la liste pour que ça ne soit plus traité
                if (nextPosUP.getY() == -1) {
                    listNextPos.remove(nextPosUP);
                }
                if (nextPosLEFT.getX() == -1) {
                    listNextPos.remove(nextPosLEFT);
                }
                if (nextPosRIGHT.getX() == 16) {
                    listNextPos.remove(nextPosRIGHT);
                }
                if (nextPosDOWN.getY() == 11) {
                    listNextPos.remove(nextPosDOWN);
                }

                if (listNextPos.get(i) instanceof Jeton) {    //si le pion sur la position un jeton
                    indiceDirection = i;   //si deux joueurs à la même distance, il ira vers le dernier vu
                    isSmthArround = true;
                } else if (listNextPos.get(i) instanceof Pierre) {
                    listNextPos.remove(listNextPos.get(i));     //si le pion est une pierre, alors on l'enl-ve de la liste car lke monstre ne pourra plus voir derrière
                }
            }

            if (isSmthArround) {        //si pion trouvé
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
        return this.direction;  //dans le cas ou aucun jeton n'est dans le champs de vision du monstre, il gardera sa direction actuelle pour avancer
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
