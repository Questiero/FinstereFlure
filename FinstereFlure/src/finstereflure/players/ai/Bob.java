package finstereflure.players.ai;

import finstereflure.enums.Couleur;
import finstereflure.players.AI;
import finstereflure.enums.PlayerType;

public class Bob extends AI {

    public Bob(String name, Couleur color) {
        super(name, color);
    }

    @Override
    public PlayerType getType() {
        return PlayerType.BOB;
    }

}
