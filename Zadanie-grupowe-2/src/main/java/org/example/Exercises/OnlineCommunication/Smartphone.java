package org.example.Exercises.OnlineCommunication;

public class Smartphone implements CommunicatorClient {
    private final String userName;

    public Smartphone(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Notification: " + message);
    }
}
