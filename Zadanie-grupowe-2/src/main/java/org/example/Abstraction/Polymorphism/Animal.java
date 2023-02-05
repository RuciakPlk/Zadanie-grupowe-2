package org.example.Abstraction.Polymorphism;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        // Omnomnom
    }

    public abstract void tryMakeSound();

    public String getName() {
        return name;
    }

    public static void example() {
        Dog rex = new Dog("Rex");
        Cat simba = new Cat("Simba");
        Fish nemo = new Fish("Nemo");
        Bird tweety = new Bird("Tweety");

        // .eat() is available for all Animal objects
        rex.eat();
        simba.eat();
        nemo.eat();
        tweety.eat();

        // these methods are unique to their respective Animal subclasses
        rex.bark();
        simba.meow();
        nemo.beQuiet();
        tweety.tweet();

        // Use of polymorphism - a collection of objects of different types with a common superclass
        Animal[] animals = new Animal[] { rex, simba, nemo, tweety };
        for (Animal animal : animals) {
            animal.eat();
            animal.tryMakeSound();
        }

        // Use of polymorphism - upcasting (implicit)
        Animal rexAsAnimal = rex; // upcasting is always safe
        // rexAsAnimal.bark(); - can't invoke .bark() method on rexAsAnimal, because it is perceived as Animal

        // Use of polymorphism - downcasting (explicit)
        Dog alsoAlsoRex = (Dog) rexAsAnimal; // downcasting is potentially dangerous
        alsoAlsoRex.bark();

        if (rexAsAnimal instanceof Cat) {
            System.out.println("rexAsAnimal is a Cat, we can downcast!");
            Cat rexIsNotACat = (Cat) rexAsAnimal; // since rexAsAnimal is actually a Dog, this will crash
            rexIsNotACat.meow();
        }
        else {
            System.out.println("rexAsAnimal is not a Cat, do not try to downcast!");
        }
    }
}
