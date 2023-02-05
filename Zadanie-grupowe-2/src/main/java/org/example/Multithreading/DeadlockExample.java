package org.example.Multithreading;

public class DeadlockExample {
    public static final String messageOne = "Something";
    public static final String messageTwo = "Something Else";

    public static void example() {
        Thread threadA = new Thread(() -> {
            synchronized (messageOne) {
                System.out.println("Thread A has locked Message One");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (messageTwo) {
                    System.out.println("Thread B has locked Message Two");
                }
            }
        });

        Thread threadB = new Thread(() -> {
           synchronized (messageTwo) {
               System.out.println("Thread B has locked Message Two");
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

               synchronized (messageOne) {
                   System.out.println("Thread A has locked Message One");
               }
           }
        });

        threadA.start();
        threadB.start();

        // Explanation:
        // Thread A requires to lock Message One, then Message Two
        // Thread B requires to lock Message Two, then Message One
        // Thread A locks Message One
        // Thread B locks Message Two
        // Thread A waits for Thread B to unlock Message Two
        // Thread B waits for Thread A to unlock Message One
        // Both threads are stuck
        // This is called a Deadlock
    }
}
