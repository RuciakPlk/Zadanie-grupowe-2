package org.example.Inheritance.Company;

public class Customer extends Person {
    private Integer availableMoney;

    // Constructor overloading
    // Define a constructor of the subclass with the exact same parameters as the constructor from the superclass
    public Customer(String name, Integer age, Integer availableMoney) {
        super(name, age); // in order not to duplicate code, use the "super" call, to use the superclass's constructor
        this.availableMoney = availableMoney;
    }

    public Integer getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(Integer availableMoney) {
        this.availableMoney = availableMoney;
    }
}
