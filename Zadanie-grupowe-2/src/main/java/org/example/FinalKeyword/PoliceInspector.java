package org.example.FinalKeyword;

// Final classes cannot be inherited from!
public final class PoliceInspector extends Policeman {
    public PoliceInspector(String firstName, String lastName, Integer yearOfBirth) {
        super(firstName, lastName, yearOfBirth);
    }
}
