package org.example.Inheritance.Evolution;

public class Human extends Mammal {
    private String name;

    public void speak(String whatToSay) {

    }

    @Override
    protected Boolean mateWith(Animal mate) {
        if (mate instanceof Human) {
            if (mate.isAlive) {
                return false;
            }
            else {
                speak("Salut, voulez-vous coucher avec moi?");
                return true;
            }
        }
        else {
            return false;
        }
    }
}
