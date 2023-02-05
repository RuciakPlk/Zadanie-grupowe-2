package org.example.Abstraction.Polymorphism;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void tryMakeSound() {
        tweet();
    }

    public void tweet() {
        System.out.println("Tweet");
    }
}
