package finstereflure;

/**
 * Couleur disponibles pour les jetons
 */
public enum Couleur {
    BLUE,
    BROWN,
    GRAY,
    GREEN,
    PURPLE,
    RED,
    YELLOW;

    @Override
    public String toString() {

        switch (this) {
            case BLUE:
                return "bleu";
            case BROWN:
                return "brun";
            case GRAY:
                return "gris";
            case GREEN:
                return "vert";
            case PURPLE:
                return "violet";
            case RED:
                return "rouge";
            case YELLOW:
                return "jaune";
        }

        return null;

    }

    public Couleur getType(String s) {

        Couleur color = null;

        s = s.toLowerCase();
        s = s.strip();

        switch (s) {

            case "bleu":
            case "blue":
                color = Couleur.BLUE;
                break;
            case "brun":
            case "brown":
                color = Couleur.BROWN;
                break;
            case "gris":
            case "gray":
            case "grey":
                color = Couleur.GRAY;
                break;
            case "vert":
            case "green":
                color = Couleur.GREEN;
                break;
            case "violet":
            case "purple":
                color = Couleur.PURPLE;
                break;
            case "jaune":
            case "yellow":
                color = Couleur.YELLOW;
                break;

        }

        return color;

    }

}
