package org.example.FunctionalProgramming.FunctionalInterfaces.AnonymousClassImplementation;

import org.example.FunctionalProgramming.FunctionalInterfaces.TraditionalImplementation.Action;

public class Example {
    public static void example() {
        // These are NOT instances of the interface Action
        // These are instances of anonymous classes, which implement the Action interface

        // Anonymous class is a nameless class, which is defined once, for just one object,
        // and implements a single interface
        Action helloWorld = new Action() {
            @Override
            public void invoke() {
                System.out.println("Hello, World!");
            }
        };
        Action goodbye = new Action() {
            @Override
            public void invoke() {
                System.out.println("Goodbye!");
            }
        };

        Boolean shouldSayHello = true;

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
