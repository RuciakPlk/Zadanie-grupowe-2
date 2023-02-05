package org.example.Multithreading;

public class Counter implements Runnable {
    private final String name;
    private Integer current;
    private final Integer target;
    private Boolean isFinished;

    public Counter(String name, Integer from, Integer to) {
        this.name = name;
        this.current = from;
        this.target = to;
        this.isFinished = false;
    }

    @Override
    public void run() {
        for (; current <= target; current++) {
            System.out.println(this.name + ": " + current);
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
        Counter counterA = new Counter("A", 0, 100);
        Counter counterB = new Counter("B", 0, 100);

        // Single-thread behavior - run A, then run B
        // System.out.println("Single-thread");
        // counterA.run();
        // counterB.run();

        // Multi-thread behavior - run A and B at the same time
        System.out.println("Multi-thread");
        Thread threadA = new Thread(counterA);
        Thread threadB = new Thread(counterB);

        threadA.start();
        threadB.start();

        while (!counterA.getFinished() || !counterB.getFinished()) {
            // Wait
            Thread.sleep(100);
        }

        System.out.println("Both threads have finished their work!");
    }
}
