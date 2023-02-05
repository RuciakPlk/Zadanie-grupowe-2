package org.example.Exercises.OnlineCommunication;

public class Computer implements CommunicatorClient {
    private final Integer computerId;

    public Computer(Integer computerId) {
        this.computerId = computerId;
    }

    @Override
    public String getUserName() {
        return "ComputerUser#" + computerId;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Displaying message on screen: " + message);
    }
}
