package finstereflure.pions;

import javax.swing.ImageIcon;

public abstract class Pion {
    
    private final ImageIcon sprite;
    
    public Pion(ImageIcon sprite) {
        this.sprite = sprite;
    }
    
    public Pion(String spritePath) {
        this.sprite = new ImageIcon(spritePath);
    }
    
}
