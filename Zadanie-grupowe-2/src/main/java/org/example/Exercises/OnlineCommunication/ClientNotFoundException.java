package org.example.Exercises.OnlineCommunication;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
    }

    public ClientNotFoundException(CommunicatorClient client) {
        super("Client with username " + client.getUserName() + " was not found!");
    }
}
