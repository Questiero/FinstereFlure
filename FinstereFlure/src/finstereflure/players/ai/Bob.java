package finstereflure.players.ai;

import finstereflure.Couleur;
import finstereflure.players.AI;
import finstereflure.players.PlayerType;

public class Bob extends AI {

    public Bob(String name, Couleur color) {
        super(name, color);
    }

    @Override
    public PlayerType getType() {
        return PlayerType.BOB;
    }

}
