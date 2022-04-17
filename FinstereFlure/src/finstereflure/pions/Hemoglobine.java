package finstereflure.pions;

import finstereflure.Terrain;

public final class Hemoglobine extends Pion {

    public Hemoglobine(Terrain terrain, int x, int y) {
        super(terrain, x, y, 0, "");
    }

    @Override
    public String generateSpritePath() {
        return "";
    }

}
