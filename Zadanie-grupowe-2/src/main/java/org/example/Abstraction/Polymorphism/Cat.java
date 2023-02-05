package org.example.Abstraction.Polymorphism;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void tryMakeSound() {
        meow();
    }

    public void meow() {
        System.out.println("Meow");
    }
}
