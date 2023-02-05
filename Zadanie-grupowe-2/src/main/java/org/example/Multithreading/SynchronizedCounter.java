package org.example.Multithreading;

public class SynchronizedCounter implements Runnable {
    private static CounterInteger counter = new CounterInteger(0);

    private final String name;
    private Boolean isFinished;

    public SynchronizedCounter(String name) {
        this.name = name;
        this.isFinished = false;
    }

    @Override
    public void run() {
        while (true) {
            // Synchronized block makes a reservation for accessing this variable
            // Waits for it to be available and then restricts it for its own purposes
            synchronized (counter) {
                if (counter.getValue() >= 100) {
                    break;
                }

                counter.setValue(counter.getValue() + 1);
                System.out.println(this.name + ": " + counter.getValue());
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.isFinished = true;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public static void example() throws InterruptedException {
        SynchronizedCounter counterA = new SynchronizedCounter("A");
        SynchronizedCounter counterB = new SynchronizedCounter("B");

        Thread threadA = new Thread(counterA);
        Thread threadB = new Thread(counterB);

        threadA.start();
        threadB.start();

        while (!counterA.getFinished() || !counterB.getFinished()) {
            Thread.sleep(100);
        }

        System.out.println("Both threads have finished their work.");
        System.out.println(counter.getValue());
    }
}
