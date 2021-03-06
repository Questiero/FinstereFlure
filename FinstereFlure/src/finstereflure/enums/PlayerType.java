package finstereflure.enums;

/**
 * Type du joueur
 */
public enum PlayerType {
    HUMAN,
    BOB;

    /**
     * Permet d'extraire un PlqyerType d'une chaîne de caractère
     *
     * @param s
     * @return Couleur
     */
    public static PlayerType getType(String s) {

        PlayerType type = null;

        s = s.toLowerCase();
        s = s.strip();

        switch (s) {
            case "human":
                type = PlayerType.HUMAN;
                break;
            case "ai - bob":
                type = PlayerType.BOB;
                break;
        }

        return type;

    }

    public String toString() {

        switch (this) {
            case HUMAN:
                return "Human";
            case BOB:
                return "Bob";

        }

        return null;

    }
}
