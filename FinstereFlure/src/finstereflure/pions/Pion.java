package finstereflure.pions;

import javax.swing.ImageIcon;

/**
 * Pion du jeu
 */
public abstract class Pion {
    
    private final ImageIcon sprite;
    
    /**
     * Constructeur de Pion en fonction d'un ImageIcon pour sprite
     * 
     * @param sprite 
     */
    public Pion(ImageIcon sprite) {
        this.sprite = sprite;
    }
    
    /**
     * Constructeur de Pion en fonction du chemin d'accès à son sprite
     * 
     * @param spritePath chemin d'accès au sprite
     */
    public Pion(String spritePath) {
        this.sprite = new ImageIcon(spritePath);
    }
    
}
