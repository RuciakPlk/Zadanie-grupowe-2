package org.example.Abstraction.Polymorphism;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void tryMakeSound() {
        bark();
    }

    public void bark() {
        System.out.println("Woof woof");
    }
}
