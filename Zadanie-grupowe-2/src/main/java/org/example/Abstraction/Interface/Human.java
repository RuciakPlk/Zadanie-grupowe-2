package org.example.Abstraction.Interface;

public class Human implements Speakable, Eatable {
    @Override
    public void speak(String speech) {
        System.out.println("I am human and I say: " + speech);
    }

    public static void example() {
        Human human = new Human();
        TalkingParrot parrot = new TalkingParrot();
        Toy toy = new Toy();

        human.speak("Human speaks");
        parrot.speak("Talking parrot speaks");
        toy.speak("Toy speaks");

        Speakable[] speakables = new Speakable[] { human, parrot, toy };
        for (Speakable speakable : speakables) {
            speakable.speak("Speakable object speaks");
        }

        Eatable[] eatables = new Eatable[] { human, parrot };
        for (Eatable eatable : eatables) {
            eatable.eat("Bread");
        }

        // Upcasting and downcasting work the same as with classes
        Speakable speakableHuman = human; // upcasting Human to Speakable

        if (speakableHuman instanceof Human) {
            Human humanBackFromSpeakable = (Human) speakableHuman; // downcasting Speakable to Human
        }
        else {

        }
    }

    @Override
    public void eat(String food) {
        System.out.println(food + " is very tasty, thank you!");
    }
}
