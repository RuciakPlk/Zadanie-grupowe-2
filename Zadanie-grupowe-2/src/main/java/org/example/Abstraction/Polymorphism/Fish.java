package org.example.Abstraction.Polymorphism;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void tryMakeSound() {
        beQuiet();
    }

    public void beQuiet() {
        System.out.println("...");
    }
}
