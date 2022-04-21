package finstereflure;

import finstereflure.pions.Empty;
import finstereflure.pions.Hemoglobine;
import finstereflure.pions.Jeton;
import finstereflure.pions.Monstre;
import finstereflure.pions.Pierre;
import finstereflure.pions.Pion;
import finstereflure.players.Player;
import java.util.LinkedList;
import javax.swing.ImageIcon;
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
     * Constructeur de Terrain avec dimensions personnalisées
     *
     * @param layeredPane layeredPane dans lequel le Terrain sera affiché
     * @param game Partie dans laquelle le Terrain est contenu
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
     * @param layeredPane layeredPane dans lequel le Terrain sera affiché
     * @param game Partie dans laquelle le Terrain est contenu
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
                this.pionMap[i][j].add(new Empty(this.game, i, j));

                // Init layeredPane
                this.spriteMap[i][j] = new JLabel();
                this.spriteMap[i][j].setBounds(24 + i * 40, 19 + j * 40, 40, 40);
                this.layeredPane.add(this.spriteMap[i][j], 1);

            }
        }

        // Init Monstre
        Monstre monstre = new Monstre(this.game, 0, 0);
        this.pionMap[0][0].add(monstre);
        this.game.setMonstre(monstre);

        // Init jetons
        int[] values = {1, 3, 4, 5};

        // Init joueur 1
        Player p1 = this.game.getPlayer1();
        for (int value : values) {
            // Init des jetons du joueur 1
            if (!(p1.getMaxJetons() == 3 && value == 3)) {
                Jeton jeton = new Jeton(this.game, 15, 10, "", p1, value);
                this.pionMap[15][10].add(jeton);
                jeton.generateSprite();
                p1.getJetons().add(jeton);
            }
        }

        // Init joueur 2
        Player p2 = this.game.getPlayer2();
        for (int value : values) {
            // Init des jetons du joueur 1
            if (!(p2.getMaxJetons() == 3 && value == 3)) {
                Jeton jeton = new Jeton(this.game, 15, 10, "", p2, value);
                this.pionMap[15][10].add(jeton);
                jeton.generateSprite();
                p2.getJetons().add(jeton);
            }
        }

        if (!isAdvanced) {

            int[][] coordsPierres = {{2, 2}, {7, 4}, {8, 5}, {12, 3}, {13, 5}, {6, 6}, {4, 7}, {11, 7}, {14, 8}, {5, 9}, {8, 9}};

            // Positionnement des pierres
            for (int[] coord : coordsPierres) {
                LinkedList<Pion> ll = this.pionMap[coord[0]][coord[1]];
                ll.add(new Pierre(this.game, coord[0], coord[1], ll.size()));
            }

            // Postionnement de la flaque d'Hemoglobine horizontale
            JLabel flaqueLongue = new JLabel();
            flaqueLongue.setIcon(new ImageIcon("./img/tachesang_lineaireH.png"));
            this.layeredPane.add(flaqueLongue, -1);
            flaqueLongue.setBounds(184, 339, 160, 40);

            for (int i = 4; i <= 7; i++) {
                this.pionMap[i][8].add(new Hemoglobine(this.game, i, 8));
            }

            // Postionnement de la flaque d'Hemoglobine carrée
            JLabel flaqueCarre = new JLabel();
            flaqueCarre.setIcon(new ImageIcon("./img/tachesang_carree.png"));
            this.layeredPane.add(flaqueCarre, -1);
            flaqueCarre.setBounds(344, 99, 80, 80);

            for (int i = 8; i <= 9; i++) {
                for (int j = 2; j <= 3; j++) {
                    this.pionMap[i][j].add(new Hemoglobine(this.game, i, j));
                }
            }

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
