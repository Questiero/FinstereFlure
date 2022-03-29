package finstereflure;

import finstereflure.pions.Empty;
import finstereflure.pions.Jeton;
import finstereflure.pions.Monstre;
import finstereflure.pions.Pierre;
import finstereflure.pions.Pion;
import finstereflure.players.Player;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Terrain de jeu
 */
public class Terrain {

    private final JLayeredPane layeredPane;

    private final Partie game;

    private LinkedList<Pion>[][] pionMap;
    private JLabel[][] spriteMap;

    /**
     * Constructeur de Terrain avec dimensions classiques
     */
    public Terrain(JLayeredPane layeredPane, Partie game) {
        this.layeredPane = layeredPane;
        this.pionMap = new LinkedList[16][11];
        this.spriteMap = new JLabel[16][11];
        this.game = game;
    }

    /**
     * Constructeur de Terrain avec dimensions personnalisées
     *
     * @param x largeur du terrain
     * @param y hauteur du terrain
     */
    public Terrain(int x, int y, JLayeredPane layeredPane, Partie game) {
        this.layeredPane = layeredPane;
        this.pionMap = new LinkedList[x][y];
        this.spriteMap = new JLabel[x][y];
        this.game = game;
    }

    /**
     * Initialisation du terrain
     *
     * @param isAdvanced
     */
    public void init(boolean isAdvanced) {

        for (int i = 0; i < this.pionMap.length; i++) {
            for (int j = 0; j < this.pionMap[i].length; j++) {

                // Init pionMap
                this.pionMap[i][j] = new LinkedList<Pion>();

                // Init Empty
                this.pionMap[i][j].add(new Empty(this, i, j));

                // Init layeredPane
                this.spriteMap[i][j] = new JLabel();
                this.spriteMap[i][j].setBounds(24 + i * 40, 19 + j * 40, 40, 40);
                this.layeredPane.add(this.spriteMap[i][j]);

            }
        }

        // Init Monstre
        this.pionMap[0][0].add(new Monstre(this, 0, 0, 1));

        // Init jetons
        int[] values = {1, 3, 4, 5};

        Player p1 = this.game.getPlayer1();
        for (int value : values) {
            if (!(p1.getMaxJetons() == 3 && value == 3)) {
                Jeton jeton = new Jeton(this, 15, 10, this.pionMap[15][10].size(), "", p1, value);
                this.pionMap[15][10].add(jeton);
                jeton.generateSprite();
                p1.getJetons().add(jeton);
            }
        }

        Player p2 = this.game.getPlayer1();
        for (int value : values) {
            if (!(p2.getMaxJetons() == 3 && value == 3)) {
                Jeton jeton = new Jeton(this, 15, 10, this.pionMap[15][10].size(), "", p2, value);
                this.pionMap[15][10].add(jeton);
                jeton.generateSprite();
                p2.getJetons().add(jeton);
            }
        }

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

        this.update();

    }

    public LinkedList<Pion>[][] getPionMap() {
        return this.pionMap;
    }

    public JLabel[][] getSpriteMap() {
        return this.spriteMap;
    }

    /**
     * Redraw tout les sprites du terrain
     */
    public void update() {
        for (LinkedList[] array : this.pionMap) {
            for (LinkedList<Pion> ll : array) {
                ll.getLast().draw();
            }
        }
    }

}
