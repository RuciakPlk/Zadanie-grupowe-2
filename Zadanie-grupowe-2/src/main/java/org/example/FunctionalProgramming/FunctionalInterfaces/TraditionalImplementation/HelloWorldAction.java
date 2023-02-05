package org.example.FunctionalProgramming.FunctionalInterfaces.TraditionalImplementation;

public class HelloWorldAction implements Action {
    @Override
    public void invoke() {
        System.out.println("Hello, World!");
    }
}
