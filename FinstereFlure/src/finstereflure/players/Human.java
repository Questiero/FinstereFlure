package finstereflure.players;

import finstereflure.enums.PlayerType;
import finstereflure.enums.Couleur;

public class Human extends Player {

    public Human(String name, Couleur color) {
        super(name, color);
    }

    @Override
    public PlayerType getType() {
        return PlayerType.HUMAN;
    }

}
