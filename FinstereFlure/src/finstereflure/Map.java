package finstereflure;

import finstereflure.pions.Pion;
import java.util.Arrays;

public class Map {
    
    private Pion[][] map = new Pion[16][11];
    
    public Map() {
        this.init();
    }

    private void init() {
        
        Arrays.fill(map, null);
        
    }
    
}
