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
        
        switch(this) {
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
    
}
