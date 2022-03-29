package finstereflure.enums;

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
                return "blue";
            case BROWN:
                return "brown";
            case GRAY:
                return "gray";
            case GREEN:
                return "green";
            case PURPLE:
                return "purple";
            case RED:
                return "red";
            case YELLOW:
                return "yellow";
        }

        return null;

    }

    public static Couleur getType(String s) {

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
