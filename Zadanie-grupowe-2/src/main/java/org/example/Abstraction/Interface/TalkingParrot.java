package org.example.Abstraction.Interface;

public class TalkingParrot implements Speakable, Eatable {
    @Override
    public void speak(String speech) {
        System.out.println("Parrot say: " + speech);
    }

    @Override
    public void eat(String food) {
        System.out.println("Nom nom nom");
    }
}
