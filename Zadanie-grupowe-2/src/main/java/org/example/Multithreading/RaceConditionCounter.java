package org.example.Multithreading;

public class RaceConditionCounter implements Runnable {
    private static Integer counter = 0;

    private final String name;
    private Boolean isFinished;

    public RaceConditionCounter(String name) {
        this.name = name;
        this.isFinished = false;
    }

    @Override
    public void run() {
        for (; counter <= 100; counter++) {
            System.out.println(this.name + ": " + counter);
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
        RaceConditionCounter counterA = new RaceConditionCounter("A");
        RaceConditionCounter counterB = new RaceConditionCounter("B");

        Thread threadA = new Thread(counterA);
        Thread threadB = new Thread(counterB);

        threadA.start();
        threadB.start();

        while (!counterA.getFinished() || !counterB.getFinished()) {
            Thread.sleep(100);
        }

        System.out.println("Both threads have finished their work.");
        System.out.println(counter);
    }
}
