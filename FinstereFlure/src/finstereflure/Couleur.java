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
    
}
