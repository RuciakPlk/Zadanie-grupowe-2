package org.example.FunctionalProgramming.FunctionalInterfaces.TraditionalImplementation;

public class Example {
    public static void example() {
        Action helloWorld = new HelloWorldAction();
        Action goodbye = new SayGoodbyeAction();

        Boolean shouldSayHello = false;

        doIf(shouldSayHello, helloWorld, goodbye);
    }

    public static void doIf(Boolean condition, Action actionIfTrue, Action actionIfFalse) {
        if (condition) {
            actionIfTrue.invoke();
        }
        else {
            actionIfFalse.invoke();
        }
    }
}
