package finstereflure;

import finstereflure.enums.Couleur;
import finstereflure.enums.PlayerType;
import finstereflure.pions.Jeton;
import finstereflure.pions.Monstre;
import finstereflure.players.*;
import finstereflure.players.ai.*;
import javax.swing.JLayeredPane;

/**
 * Gestion d'une partie de jeu
 */
public class Partie {

    private final Host host;

    private final Player[] players = new Player[2];
    private final Terrain terrain;

    private boolean advancedMode = false;

    private int manche = 2;
    private int tour = 1;
    public int playerTurn = 1;

    private Jeton currentJeton;
    private Monstre monstre;

    /**
     * Constructeur de Partie en fonction de son hôte
     *
     * @param host Hôte de la partie
     * @param layeredPane
     */
    public Partie(Host host, JLayeredPane layeredPane) {
        this.host = host;
        this.terrain = new Terrain(layeredPane, this);
    }

    /**
     * Initialisaiton de la partie en fonction des données fournies via
     * l'interface graphique
     *
     * @param namep1 Nom du premier joueur
     * @param colorp1 Couleur du premier joueur
     * @param typep1 Type du premier joueur
     * @param namep2 Nom du second joueur
     * @param colorp2 Couleur du second joueur
     * @param typep2 Type du second joueur
     * @param isAdvanced Mode avancé
     */
    public void init(String namep1, Couleur colorp1, PlayerType typep1, String namep2, Couleur colorp2, PlayerType typep2, boolean isAdvanced) {

        Player p1;

        switch (typep1) {
            case HUMAN:
                p1 = new Human(namep1, colorp1);
                break;
            case BOB:
                p1 = new Bob(namep1, colorp1);
                break;
            default:
                p1 = null;
        }

        Player p2;

        switch (typep2) {
            case HUMAN:
                p2 = new Human(namep2, colorp2);
                break;
            case BOB:
                p2 = new Bob(namep2, colorp2);
                break;
            default:
                p2 = null;
        }

        this.init(p1, p2, isAdvanced);

    }

    /**
     * Initialiisation de la partie à partir de deux joueurs
     *
     * @param p1 Premier joueur
     * @param p2 Second joueur
     * @param isAdvanced Mode avancé
     */
    private void init(Player p1, Player p2, boolean isAdvanced) {

        this.players[0] = p1;
        this.players[1] = p2;

        this.advancedMode = isAdvanced;

        this.terrain.init(this.advancedMode);

    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Player getPlayer1() {
        return this.players[0];
    }

    public Player getPlayer2() {
        return this.players[1];
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

    public int getManche() {
        return manche;
    }

    public void nextManche() {
        this.manche++;
        this.resetTour();
    }

    public int getTour() {
        return tour;
    }

    public void nextTour() {
        this.tour++;
    }

    public void resetTour() {
        this.tour = 1;
        this.resetPlayerTurn();
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void nextPlayerTurn() {

        for (Jeton j : this.players[this.playerTurn - 1].getJetons()) {
            j.resetPlay();
        }

        this.playerTurn++;

        if (this.playerTurn == 3) {
            this.monsterTurn();
        }
        
        this.currentJeton = null;
        
    }

    public boolean canNextPlayerTurn() {

        if (this.playerTurn == 3) {
            //TODO Monstre
        } else {
            for (Jeton j : this.players[this.playerTurn - 1].getJetons()) {
                if (j.isCanPlay()) {
                    return false;
                }
            }
        }
        return true;

    }

    public void resetPlayerTurn() {
        this.playerTurn = 1;
    }

    public Jeton getCurrentJeton() {
        return currentJeton;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public void selectJeton(int player, int pion) {
        if (this.players[player].getJetons().size() > pion) {
            this.currentJeton = this.players[player].getJetons().get(pion);
        }
    }

    public boolean shouldMancheEnd() {
        return this.getPlayer2().getJetons().isEmpty() && this.getPlayer1().getJetons().isEmpty();
    }

    @Override
    public String toString() {
        return ("Joueur 1 : \t" + players[0] + "\nJoueur 2 : \t" + players[1]);
    }

    public void monsterTurn() {

        System.out.println("Tour du monstre");

        this.monstre.move(this.monstre.getTargetDirection());

        this.playerTurn = 1;
        this.nextTour();

    }

}
