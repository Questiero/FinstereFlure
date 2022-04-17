package finstereflure.enums;

public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

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
