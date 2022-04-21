package finstereflure.enums;

public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    /**
     * Permet d'obtenir la direction obtenue lors d'une rotation "à gauche",
     * c'est-à-dire dans le sens anti-horaire
     *
     * @return Direction
     */
    public Direction rotateLeft() {

        Direction dir = this;

        switch (this) {

            case UP:
                dir = LEFT;
                break;
            case LEFT:
                dir = DOWN;
                break;
            case DOWN:
                dir = RIGHT;
                break;
            case RIGHT:
                dir = UP;
                break;

        }

        return dir;

    }

    /**
     * Permet d'obtenir la direction obtenue lors d'une rotation "à gauche",
     * c'est-à-dire dans le sens horaire
     *
     * @return Direction
     */
    public Direction rotateRight() {

        Direction dir = this;

        switch (this) {

            case UP:
                dir = RIGHT;
                break;
            case RIGHT:
                dir = DOWN;
                break;
            case DOWN:
                dir = LEFT;
                break;
            case LEFT:
                dir = UP;
                break;

        }

        return dir;

    }

}
