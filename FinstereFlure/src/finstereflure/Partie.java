package finstereflure;

import finstereflure.enums.Couleur;
import finstereflure.enums.PierreTombale;
import finstereflure.enums.PlayerType;
import finstereflure.pions.Jeton;
import finstereflure.pions.Monstre;
import finstereflure.players.*;
import finstereflure.players.ai.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLayeredPane;

/**
 * Gestion d'une partie de jeu
 */
public class Partie {

    private final Interface interf;

    private final Host host;

    private final Player[] players = new Player[2];
    private final Terrain terrain;

    private boolean advancedMode = false;

    private int manche = 1;
    private int turn = 1;
    private int playerTurn = 1;

    private Jeton currentJeton;
    private Monstre monstre;

    private int maxTombstone = 0;
    private ArrayList<PierreTombale> tombstoneDeck = new ArrayList<>();
    private ArrayList<PierreTombale> tombstonePlayed = new ArrayList<>();

    /**
     * Constructeur de Partie en fonction de son hôte
     *
     * @param host Hôte de la partie
     * @param layeredPane
     */
    public Partie(Interface interf, Host host, JLayeredPane layeredPane) {
        this.interf = interf;
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

        this.tombstoneDeck.add(PierreTombale.PAS_5);
        this.tombstoneDeck.add(PierreTombale.PAS_7);
        this.tombstoneDeck.add(PierreTombale.PAS_7);
        this.tombstoneDeck.add(PierreTombale.PAS_8);
        this.tombstoneDeck.add(PierreTombale.PAS_8);
        this.tombstoneDeck.add(PierreTombale.PAS_10);
        this.tombstoneDeck.add(PierreTombale.VICTIME_1);
        this.tombstoneDeck.add(PierreTombale.VICTIME_2);

        this.maxTombstone = this.tombstoneDeck.size();

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

        this.tombstoneDeck.addAll(this.tombstonePlayed);
        this.tombstonePlayed.clear();

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
            return false;
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

    public int getTurn() {
        return turn;
    }

    public int getMaxTombstone() {
        return maxTombstone;
    }

    public boolean selectJeton(int player, int pion) {
        if (this.players[player].getJetons().size() > pion) {
            this.currentJeton = this.players[player].getJetons().get(pion);
            return true;
        }
        return false;
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

        PierreTombale tombstone = this.getTombstone();

        // Mise à jour de l'affichage
        String str = "";
        switch (tombstone) {

            case PAS_5:
            case PAS_7:
            case PAS_8:
            case PAS_10:
                str = tombstone.getValue() + " steps";
                break;
            case VICTIME_1:
            case VICTIME_2:
                str = tombstone.getValue() + " preys";
                break;
        }
        this.interf.setTombstoneDisplayText(str);
        this.interf.setRemainingTombstoneText("Remaining tombstones : " + this.tombstoneDeck.size() + "/" + this.maxTombstone);

        this.monstre.setPas(0);
        this.monstre.setVictimes(0);

        // Création d'un Runnable et d'un thread secondaire afin d'obtenir une animation de déplacement du monstre
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        final Future<?>[] f = {null};

        f[0] = exec.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {

                monstre.move(monstre.getTargetDirection());

                // Vérification des conditions d'arrêt à chaque mouvement
                switch (tombstone) {

                    case PAS_5:
                    case PAS_7:
                    case PAS_8:
                    case PAS_10:

                        // Mise à jour de l'affichage
                        interf.setMonsterObjectiveText("Steps " + monstre.getPas() + "/" + tombstone.getValue());

                        if (monstre.getPas() >= tombstone.getValue()) {
                            this.cancel();
                            return;
                        }

                        break;

                    case VICTIME_1:
                    case VICTIME_2:

                        // Mise à jour de l'affichage
                        interf.setMonsterObjectiveText("Preys " + monstre.getVictimes() + "/" + tombstone.getValue());

                        if (monstre.getVictimes() >= tombstone.getValue() || monstre.getPas() >= 20) {
                            this.cancel();
                            return;
                        }

                        break;

                }

            }

            private void cancel() {

                // Arrêt du thread
                f[0].cancel(false);

                playerTurn = 1;

                turn++;

                interf.updateNewTurn();

                // Mise à jour de l'affichage
                interf.setRoundText(String.valueOf(manche));
                interf.setTurnText(String.valueOf(turn));

                getPlayer1().resetJetonsPlayed();
                getPlayer2().resetJetonsPlayed();

                if (isGameWon() != 0) {
                    interf.endGame();
                }

                return;
            }

        }, 0, 200, TimeUnit.MILLISECONDS);

    }

    /**
     *
     * @return le numéro du joueur gagnant, 0 sinon, 3 si égalité
     */
    public int isGameWon() {
//si 3pions sortis gagné
//si tous dévorés alors celui qui en a le plus sortis

        if (this.players[0].canWin() || (this.players[1].getJetons().size() == 0) && this.players[0].getJetons().size() != 0) {
            return 1;
        } else if (this.players[1].canWin() || (this.players[0].getJetons().size() == 0) && this.players[1].getJetons().size() != 0) {
            return 2;
        } else if (this.players[0].getJetons().size() == 0 && this.players[1].getJetons().size() == 0) {
            if (this.players[0].getJetonsWon().size() > this.players[1].getJetonsWon().size()) {
                return 1;
            } else if (this.players[0].getJetonsWon().size() < this.players[1].getJetonsWon().size()) {
                return 2;
            } else {
                return 3;
            }
        }

        return 0;

    }

    /**
     *
     * @return pierre tombale qui sera jouée par le monstre ce tour-ci
     */
    public PierreTombale getTombstone() {

        if (this.tombstoneDeck.size() == 1) {
            if (this.manche == 1) {
                this.nextManche();
            } else {
                this.interf.endGame();
            }
        }

        PierreTombale tombstone = null;

        boolean found = false;

        while (!found) {

            tombstone = this.tombstoneDeck.get((new Random()).nextInt(this.tombstoneDeck.size()));

            this.tombstoneDeck.remove(tombstone);
            this.tombstonePlayed.add(tombstone);

            if (!(this.turn == 1 && (tombstone == PierreTombale.VICTIME_1 || tombstone == PierreTombale.VICTIME_2))) {
                // Impossible d'avoir une pierre de type VICTIME au premier tour
                found = true;
            }

        }

        return tombstone;

    }

}
