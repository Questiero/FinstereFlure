package finstereflure.pions;

import finstereflure.Partie;

/**
 * Pion vide, placeholder
 */
public final class Empty extends Pion {

    public Empty(Partie partie, int x, int y) {
        super(partie, x, y, 0, "");
    }

    @Override
    public String generateSpritePath() {
        return "";
    }

}
