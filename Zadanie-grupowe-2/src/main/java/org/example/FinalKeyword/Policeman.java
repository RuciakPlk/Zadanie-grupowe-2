package org.example.FinalKeyword;

public class Policeman extends Person {
    public Policeman(String firstName, String lastName, Integer yearOfBirth) {
        super(firstName, lastName, yearOfBirth);
    }

    // Final methods cannot be overriden
    @Override
    public final void introduce() {
        System.out.println("Good day, my name is " + this.getFirstName() + " " + this.getLastName() + " and I am a police officer.");
    }
}
