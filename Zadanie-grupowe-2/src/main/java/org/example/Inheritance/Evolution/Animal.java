package org.example.Inheritance.Evolution;

// Organism is the superclass of Animal
// Animal is the subclass of Organism

// Each class can have multiple subclasses
// But it can only have one superclass

// Subclass has access to all non-private elements of its superclass
// Superclass has no access to elements of its subclasses
public class Animal extends Organism {
    protected Instinct instinct;

    @Override
    public void procreate() {
        // Procreate with an another mate
    }

    protected Boolean mateWith(Animal animal) {
        return true;
    }
}
