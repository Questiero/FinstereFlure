package finstereflure.enums;

/**
 * Couleurs disponibles pour les jetons
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

    /**
     * Permet d'extraire une Couleur d'une chaîne de caractère
     *
     * @param s
     * @return Couleur
     */
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
            case "red":
            case "rouge":
                color = Couleur.RED;
                break;

        }

        return color;

    }

    /**
     * Permet d'obtenir le nombre de jetons maximum à partir de la couleur
     * 
     * @return nombre de jetons maximum
     */
    public int getMaxJetons() {

        int maxJetons = 0;

        switch (this) {
            case BLUE, GREEN, RED, YELLOW:
                maxJetons = 4;
                break;
            case BROWN, PURPLE, GRAY:
                maxJetons = 3;
                break;
            default:
                maxJetons = 0;
        }

        return maxJetons;

    }

}
