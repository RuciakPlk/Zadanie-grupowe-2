package org.example.Exception;

public class Person {
    public void eatBread(Integer slicesOfBread) throws IllegalAmountOfBreadException {
        if (slicesOfBread <= 0) {
            // THROW NEW EXCEPTION!
            throw new IllegalAmountOfBreadException("Give me more bread!");
        }

        System.out.println("Eating " + slicesOfBread + " slices of bread. Yummy!");
    }
}
