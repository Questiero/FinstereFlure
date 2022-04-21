package finstereflure.pions;

import finstereflure.Partie;

/**
 * Flaque d'hémoglobine
 */
public final class Hemoglobine extends Pion {

    public Hemoglobine(Partie partie, int x, int y) {
        super(partie, x, y, "");
    }

    @Override
    public String generateSpritePath() {
        return "";
    }

}
