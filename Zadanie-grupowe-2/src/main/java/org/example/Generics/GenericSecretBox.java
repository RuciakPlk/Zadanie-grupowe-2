package org.example.Generics;

// Generic subclass of a generic superclass
// Subclass<T> extends Superclass<T>

// Non-generic subclass of a generic superclass
// Subclass extends Superclass<String>

// Generic subclass of a non-generic superclass
// Subclass<T> extends Superclass

// Non-generic subclass of a non-generic superclass
// Subclass extends Superclass

import java.util.ArrayList;

public class GenericSecretBox<T> implements ConditionalAccessObject<String, T> {
    private final T secretValue;
    private final String password;

    public GenericSecretBox(T secretValue, String password) {
        this.secretValue = secretValue;
        this.password = password;
    }

    public T tryOpen(String password) throws InvalidPasswordException {
        if (this.password.equals(password)) {
            return this.secretValue;
        }
        else {
            throw new InvalidPasswordException();
        }
    }

    @Override
    public T tryGetValue(String key) throws InvalidKeyException {
        return this.tryOpen(key);
    }

    public static void example() {
        GenericSecretBox<Integer> box = new GenericSecretBox<>(1999, "qwerty");
        try {
            Integer secretValue = box.tryOpen("qwerty");
            System.out.println(secretValue);
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password!");
        }

        GenericSecretBox<String> anotherBox = new GenericSecretBox<>("JAVA", "zaq1");
        try {
            String anotherSecretValue = anotherBox.tryOpen("zaq1");
            System.out.println(anotherSecretValue);
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password!");
        }
    }

    public static void collectionsExample() {
        GenericSecretBox<Integer> intBox = new GenericSecretBox<>(1, "");
        GenericSecretBox<String> stringBox = new GenericSecretBox<>("X", "");
        GenericSecretBox<Double> doubleBox = new GenericSecretBox<>(0.5, "");

        // <?> - unknown generic type, in general, don't use, is very problematic
        ArrayList<GenericSecretBox<?>> boxes = new ArrayList<>();
        boxes.add(intBox);
        boxes.add(stringBox);
        boxes.add(doubleBox);
    }

    // Generic method with a generic parameter
    public static <TObject> void giveMe(TObject obj) {
        System.out.println(obj.toString());
    }

    // Generic method with a generic return value (almost never used)
    public static <TObject> TObject giveSomething() {
        return null;
    }

    // Generic method with a generic return value and a generic parameter
    public static <TObject> TObject giveItBack(TObject obj) {
        return obj;
    }
}
