package finstereflure;

/**
 * Hôte de la partie
 */
public class Host {

    private String name;

    public Host(String name) {
        this.name = name;
    }

    public String getNameHost() {
        return name;
    }

    public void setNameHost(String name) {
        this.name = name;
    }

    //juste pour nous uwu
    public String toString() {
        return this.name;
    }

}
