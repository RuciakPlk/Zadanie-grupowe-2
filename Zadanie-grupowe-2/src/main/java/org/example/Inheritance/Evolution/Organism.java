package org.example.Inheritance.Evolution;

public class Organism {
    protected Boolean isAlive;
    protected Integer secondsLived;

    public Organism() {
        this.isAlive = true;
        this.secondsLived = 1;
    }

    public void procreate() {
        Organism child = new Organism();
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public Integer getSecondsLived() {
        return secondsLived;
    }
}
