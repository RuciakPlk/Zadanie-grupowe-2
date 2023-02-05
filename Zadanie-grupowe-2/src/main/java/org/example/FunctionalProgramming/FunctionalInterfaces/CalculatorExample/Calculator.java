package org.example.FunctionalProgramming.FunctionalInterfaces.CalculatorExample;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static void example() {
        Double x = 10.0;
        Double y = 5.0;

        // This is a list of calculation functions
        // De facto: list of objects, of anonymous classes, that implement the Calculation interface with a lambda expression
        List<Calculation> calculations = new ArrayList<>();
        calculations.add((a, b) -> a + b);
        calculations.add((a, b) -> a - b);
        calculations.add((a, b) -> a * b);
        calculations.add((a, b) -> a / b);

        for (Calculation calculation : calculations) {
            System.out.println(calculation.calculate(x, y));
        }

        Double z = 600.0;
        Double w = -75.0;

        for (Calculation calculation : calculations) {
            System.out.println(calculation.calculate(z, w));
        }
    }
}
