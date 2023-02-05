package org.example.Exercises.Organisms;

public class Human extends Humanoid implements Speakable {
    public Human(String name) {
        super(name);
    }

    @Override
    public void speak(String speech) {
        System.out.println("And I say: " + speech);
    }
}
