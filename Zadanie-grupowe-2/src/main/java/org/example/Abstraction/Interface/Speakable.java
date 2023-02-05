package org.example.Abstraction.Interface;

// Abstract class is a template for what a class IS
// Interface is a template for what a class CAN DO

public interface Speakable {
    // Interfaces cannot have fields!
    // Interfaces cannot be instantiated!
    // Interfaces cannot have constructors!
    // Interfaces might, but should not, have methods with bodies!
    // Classes implement interfaces, not extend them!
    // One class can implement multiple interfaces!
    // One interface can extend multiple interfaces!
    // Interfaces cannot have static methods!

    void speak(String speech);
}
