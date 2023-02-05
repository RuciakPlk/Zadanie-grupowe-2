package org.example.FunctionalProgramming.FunctionalInterfaces.LambdaImplementation;

import org.example.FunctionalProgramming.FunctionalInterfaces.TraditionalImplementation.Action;

public class Example {
    public static void example() {
        // lambda expression - shortened syntax for implementing functional interfaces in anonymous classes
        // lambda expression restrictions: only one method in the interface, and only one expression in the method!
        Action helloWorld = () -> System.out.println("Hello, World!");
        Action goodbye = () -> System.out.println("Say goodbye");

        Boolean shouldSayHelloWorld = true;

        doIf(shouldSayHelloWorld, helloWorld, goodbye);

        // inline lambda expressions
        // doIf(shouldSayHelloWorld, () -> System.out.println("Hello, World!"), () -> System.out.println("Say goodbye!"));
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
