package finstereflure;

import finstereflure.players.*;
import finstereflure.players.ai.*;

/**
 * Gestion d'une partie de jeu
 */
public class Partie {

    private final Host host;

    private Player[] players = new Player[2];
    private Terrain map;

    private boolean advancedMode = false;

    /**
     * Constructeur de Partie en fonction de son hôte
     *
     * @param host Hôte de la partie
     */
    public Partie(Host host) {
        this.host = host;
    }

    /**
     * Initialisaiton de la partie en fonction des données fournies via l'interface graphique
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

    }
    @Override
    public String toString(){
        
        return ("Joueur 1 : \t" + players[0] + "\nJoueur 2 : \t" + players[1]);
    }

}
