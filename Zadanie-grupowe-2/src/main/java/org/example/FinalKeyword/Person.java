package org.example.FinalKeyword;

public class Person {
    // Final fields can only have a value assigned once (in declaration or in constructor)
    private final String firstName;
    private final String lastName;
    private final Integer yearOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Person(String firstName, String lastName, Integer yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + this.firstName + " " + this.lastName);
    }
}
