package org.example.Exercises.Organisms;

public abstract class Organism implements Breedable {
    protected String name;

    public String getName() {
        return name;
    }

    public Organism(String name) {
        this.name = name;
    }

    @Override
    public void breed() {
        System.out.println("Making a baby in progress...");
        System.out.println("Done");
    }
}
