package org.example.Exercises.Organisms;

public abstract class Animal extends Organism implements Breathable, Eatable {
    public Animal(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println("Inhale");
        System.out.println("Exhale");
    }

    @Override
    public void eat(String food) {
        System.out.println("Nom nom nom");
    }
}
