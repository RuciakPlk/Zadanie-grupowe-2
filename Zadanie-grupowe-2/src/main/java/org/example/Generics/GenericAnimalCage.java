package org.example.Generics;

import org.example.Exercises.Organisms.*;

import java.util.ArrayList;

public class GenericAnimalCage<T extends Animal> extends GenericSecretBox<T> {
    public GenericAnimalCage(T secretValue, String password) {
        super(secretValue, password);
        System.out.println("Locked in the cage: " + secretValue.getName());
    }

    public static void example() {
        GenericAnimalCage<Cat> catCage = new GenericAnimalCage<>(new Cat("Lucyfer"), "12345");
        try {
            Cat catFromCage = catCage.tryOpen("12345");
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password!");
        }

        ConditionalAccessObject<String, Cat> catAccessObject = catCage;
        try {
            Cat catFromObject = catAccessObject.tryGetValue("12345");
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key!");
        }
    }

    public static void collectionsExample() {
        GenericAnimalCage<Human> humanCage = new GenericAnimalCage<>(new Human("Mateusz"), "qwerty");
        GenericAnimalCage<Cat> catCage = new GenericAnimalCage<>(new Cat("Garfield"), "lasagne");
        GenericAnimalCage<Sloth> slothCage = new GenericAnimalCage<>(new Sloth("Sid"), "nothing");

        // <? extends Animal> - unknown type, which extends Animal. Can be safely upcasted to Animal.
        ArrayList<GenericAnimalCage<? extends Animal>> animalCages = new ArrayList<>();
        animalCages.add(humanCage);
        animalCages.add(catCage);
        animalCages.add(slothCage);

        try {
            Animal animalFromCageOne = animalCages.get(1).tryOpen("");
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password!");
        }

        try {
            nonGenericFeed(animalCages.get(1).tryOpen(""), "Food");
            genericFeed(animalCages.get(1).tryOpen(""), "Food");
        } catch (InvalidPasswordException e) {
            throw new RuntimeException(e);
        }
    }

    // Feed an animal, using the abstract superclass parameter
    public static void nonGenericFeed(Animal animal, String food) {
        animal.eat(food);
    }

    // Feed an animal, using the generic parameter, which has the animal superclass
    public static <TAnimal extends Animal> void genericFeed(TAnimal animal, String food) {
        animal.eat(food);
    }
}
