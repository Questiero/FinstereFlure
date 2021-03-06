package finstereflure.pions.interfaces;

import finstereflure.enums.Direction;

public interface Moveable {
    
    public void move(Direction dir);
    public boolean canMove(Direction dir);
    
    public void setX(int x);
    public void setY(int y);
    
}
