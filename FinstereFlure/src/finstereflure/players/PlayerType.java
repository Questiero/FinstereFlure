package finstereflure.players;

/**
 * Type du joueur
 */
public enum PlayerType {
    HUMAN,
    BOB;

    public PlayerType getType(String s) {

        PlayerType type = null;

        s = s.toLowerCase();
        s = s.strip();

        switch (s) {
            case "human":
                type = PlayerType.HUMAN;
                break;
            case "bob":
                type = PlayerType.BOB;
                break;
        }

        return type;

    }

}
