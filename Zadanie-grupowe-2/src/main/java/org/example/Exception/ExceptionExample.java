package org.example.Exception;

import java.util.Scanner;

public class ExceptionExample {
    public static void example() throws IllegalAmountOfBreadException {
        // How to raise some common exceptions
        Integer[] emptyArray = new Integer[0];
        // System.out.println(emptyArray[1]); // This will cause ArrayIndexOutOfBoundsException

        String[] nullArray = null;
        // System.out.println(nullArray.length); // This will cause NullPointerException

        // System.out.println(10 / 0); // This will cause ArithmeticException

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many slices of bread should I eat?");
        Integer amountOfBread = scanner.nextInt();
        Person person = new Person();

        try {
            // Attempt to do some things and stop, if one of them throws an exception
            person.eatBread(amountOfBread); // This will cause IllegalAmountOfBreadException
        }
        catch (IllegalAmountOfBreadException exception) {
            // Catch the specified exception, prevent program's crash and handle the situation
            System.out.println("You've given an invalid amount of bread slices!");
        }
        catch (NullPointerException exception) {
            System.out.println("Error, person is null!");
        }
        catch (Exception exception) {
            // This will cover all other exceptions
            // Order of catches matters, it works just like if-else-if-else chain
        }
        finally {
            // Finally is a block that will ALWAYS execute, regardless of whether there was an exception or not
            System.out.println("Finished!");
        }

        // Next things to do
    }
}
