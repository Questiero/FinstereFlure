package finstereflure;

import finstereflure.pions.Empty;
import finstereflure.pions.Monstre;
import finstereflure.pions.Pierre;
import finstereflure.pions.Pion;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Terrain de jeu
 */
public class Terrain {

    private final JLayeredPane layeredPane;

    private LinkedList<Pion>[][] pionMap;
    private LinkedList<JLabel>[][] spriteMap;

    /**
     * Constructeur de Terrain avec dimensions classiques
     */
    public Terrain(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        this.pionMap = new LinkedList[16][11];
        this.spriteMap = new LinkedList[16][11];
    }

    /**
     * Constructeur de Terrain avec dimensions personnalisées
     *
     * @param x largeur du terrain
     * @param y hauteur du terrain
     */
    public Terrain(int x, int y, JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        this.pionMap = new LinkedList[x][y];
        this.spriteMap = new LinkedList[x][y];
    }

    /**
     * Initialisation du terrain
     *
     * @param isAdvanced
     */
    public void init(boolean isAdvanced) {

        // Init empty
        for (int i = 0; i < this.pionMap.length; i++) {
            for (int j = 0; j < this.pionMap[i].length; j++) {
                this.pionMap[i][j].add(new Empty(this, i, j));
            }
        }

        // Init Monstre
        this.pionMap[0][0].add(new Monstre(this, 0, 0, 1));

        if (!isAdvanced) {

            int[][] coordsPierres = {{2, 2}, {7, 4}, {8, 5}, {12, 3}, {13, 5}, {6, 6}, {4, 7}, {11, 7}, {14, 8}, {5, 9}, {8, 9}};

            for (int[] coord : coordsPierres) {
                LinkedList<Pion> ll = this.pionMap[coord[0]][coord[1]];
                ll.add(new Pierre(this, coord[0], coord[1], ll.size()));
            }

            // TODO Flaques
        } else {

            // TODO
        }

    }

    public LinkedList<Pion>[][] getPionMap() {
        return this.pionMap;
    }

    public LinkedList<JLabel>[][] getSpriteMap() {
        return this.spriteMap;
    }

    /**
     * Redraw tout les sprites du terrain
     */
    public void update() {
        for (LinkedList[] array : this.pionMap) {
            for (LinkedList<Pion> ll : array) {
                ll.getFirst().draw();
            }
        }
    }

}
