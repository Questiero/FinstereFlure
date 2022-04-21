package finstereflure.pions;

import finstereflure.Partie;
import finstereflure.enums.Direction;
import finstereflure.pions.interfaces.Moveable;
import finstereflure.players.Player;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * Clase représentant les jetons d'un joueur
 */
public final class Jeton extends Pion implements Moveable {

    private final Player player;
    private final int maxCoupsClairs;

    private boolean canPlay = true;
    private boolean estClair = true;
    private int coups;

    /**
     * Constructeur de Jeton en fonction d'un ImageIcon pour sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param sprite
     */
    public Jeton(Partie partie, int x, int y, int listIndex, ImageIcon sprite, Player player, int maxCoupsClairs) {
        super(partie, x, y, sprite);
        this.player = player;
        this.maxCoupsClairs = maxCoupsClairs - 1;
        coups = maxCoupsClairs - 1;
    }

    /**
     * Constructeur de Jeton en fonction du chemin d'accès à son sprite
     *
     * @param terrain référence du terrain
     * @param x coordonnée du Pion en x sur le terrain
     * @param y coordonnée du Pion en y sur le terrain
     * @param spritePath chemin d'accès au sprite
     */
    public Jeton(Partie partie, int x, int y, int listIndex, String spritePath, Player player, int maxCoupsClairs) {
        super(partie, x, y, spritePath);
        this.player = player;
        this.maxCoupsClairs = maxCoupsClairs;
        coups = maxCoupsClairs - 1;
    }

    public boolean isEstClair() {
        return estClair;
    }

    public void flip() {

        this.estClair = !this.estClair;
        if (this.estClair) {
            this.coups = this.maxCoupsClairs;
        } else {
            this.coups = 7 - this.maxCoupsClairs;   //nb de coups foncés
        }

        this.player.addJetonsPlayed();

        this.canPlay = false;

        this.generateSprite();

    }

    public void resetPlay() {
        this.canPlay = true;
    }

    @Override
    public void move(Direction dir) {

        LinkedList<Pion>[][] pionmap = super.terrain.getPionMap();

        if (!(pionmap[this.getX()][this.getY()].get(1) instanceof Hemoglobine)) {
            this.coups--;
        }

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

        pionmap[this.getX()][this.getY()].add(this);

        this.terrain.update();

        if (nextPos instanceof Hemoglobine && this.canMove(dir)) {
            this.move(dir);
        } else if (nextPos instanceof Pierre) {
            ((Pierre) nextPos).move(dir);
        }

        this.tryToEscape();

    }

    public boolean isCanPlay() {
        return canPlay;
    }

    @Override
    //!!!!!!!!!!!!!!!!!!!!!!!!! AJOUTER LES VERIF AVEC LES PIERRES !!!!!!!!!!!!!!!!!!!!!!!
    public boolean canMove(Direction dir) {

        LinkedList<Pion>[][] pionmap = new LinkedList[16][11];
        pionmap = super.terrain.getPionMap();

        Pion nextPos = null;   //donne dans chaque direction l'occupant de la case (après traitement)

        if (this.coups == 0 && !(pionmap[this.getX()][this.getY()].get(1) instanceof Hemoglobine)) {
            return false;
        }

        switch (dir) {
            case UP:

                if (this.getY() == 0) {
                    return false;
                }

                if ((this.getX() == 12 && this.getY() == 1) || (this.getX() == 13 && this.getY() == 2)
                        || //cas de "l'escalier" en haut à droite
                        (this.getX() == 14 && this.getY() == 3) || (this.getX() == 15 && this.getY() == 4)) {
                    return false;

                }

                nextPos = pionmap[this.getX()][this.getY() - 1].getLast();

                break;

            case LEFT:

                if (this.getX() == 0) {
                    return false;
                }

                if ((this.getX() == 1 && this.getY() == 7) || (this.getX() == 2 && this.getY() == 8)
                        || //escalier en bas à gauche
                        (this.getX() == 3 && this.getY() == 9) || (this.getX() == 4 && this.getY() == 10)) {
                    return false;
                }

                nextPos = pionmap[this.getX() - 1][this.getY()].getLast();

                break;

            case RIGHT:
                if (this.getX() == 15) {
                    return false;
                }

                if ((this.getX() == 14 && this.getY() == 3) || (this.getX() == 13 && this.getY() == 2)
                        || (this.getX() == 12 && this.getY() == 1) || (this.getX() == 11 && this.getY() == 0)) {
                    return false;

                }

                nextPos = pionmap[this.getX() + 1][this.getY()].getLast();

                break;

            case DOWN:

                if (this.getY() == 10) {
                    return false;
                }

                if ((this.getX() == 3 && this.getY() == 9) || (this.getX() == 2 && this.getY() == 8)
                        || (this.getX() == 1 && this.getY() == 7) || (this.getX() == 0 && this.getY() == 6)) {
                    return false;

                }

                nextPos = pionmap[this.getX()][this.getY() + 1].getLast();

                break;
        }

        if (nextPos instanceof Jeton) {   //cas où il y a un jeton joueur
            if (this.coups == 1) {
                return false;
            }
        } else if (nextPos instanceof Pierre) {    //cas où il y a une pierre dans la direction voulue
            return ((Pierre) nextPos).canMove(dir);
        } else if (nextPos instanceof Monstre) {
            return false;
        }

        return true;

    }

    public void push(Direction dir) {

        LinkedList<Pion>[][] pionmap = super.terrain.getPionMap();

        if (!(pionmap[this.getX()][this.getY()].get(1) instanceof Hemoglobine)) {
            this.coups--;
        }

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

        if (this.getX() >= 0 && this.getY() >= 0 && this.getX() < 16 && this.getY() < 11 && this.getX() != (12 + this.getY()) && this.getY() != (7 + this.getX())) {

            Pion nextPos = pionmap[this.getX()][this.getY()].getLast();

            pionmap[this.getX()][this.getY()].add(this);

            // Si monstre qui pousse
            if (this.partie.getPlayerTurn() == 3) {
                if (nextPos instanceof Jeton) {
                    for (Pion p : pionmap[this.getX()][this.getY()]) {
                        if (p instanceof Jeton) {
                            ((Jeton) p).push(dir);
                        }
                    }
                } else if (nextPos instanceof Pierre) {
                    ((Pierre) nextPos).move(dir);
                }
            }

            if (nextPos instanceof Hemoglobine && this.canMove(dir)) {
                this.move(dir);
            }

        }

        this.tryToEscape();

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

    public int getCoups() {
        return coups;
    }

    public void revive() {

        this.setX(15);
        this.setY(10);

        this.terrain.getPionMap()[15][10].add(this);
        this.player.getJetons().add(this);

    }

    public void die() {

        this.player.getJetons().remove(this);
        this.terrain.getPionMap()[this.getX()][this.getY()].remove(this);

    }

    private void tryToEscape() {

        if (this.getX() == 0 && this.getY() == 0 && this.coups > 0) {

            this.terrain.getPionMap()[this.getX()][this.getY()].remove(this);

            this.player.getJetons().remove(this);
            this.player.getJetonsWon().add(this);

        }

    }

}
