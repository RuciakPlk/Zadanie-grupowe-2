package org.example.Abstraction.Interface;

public class Toy implements Speakable {
    @Override
    public void speak(String speech) {
        System.out.println("Beep beep: " + speech);
    }
}
