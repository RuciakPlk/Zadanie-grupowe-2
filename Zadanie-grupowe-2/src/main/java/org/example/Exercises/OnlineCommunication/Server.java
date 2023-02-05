package org.example.Exercises.OnlineCommunication;

import java.util.ArrayList;
import java.util.List;

public class Server implements CommunicatorServer {
    private final List<CommunicatorClient> connectedClients;

    public Server() {
        this.connectedClients = new ArrayList<>();
    }

    @Override
    public void registerClient(CommunicatorClient client) {
        this.connectedClients.add(client);
    }

    @Override
    public void unregisterClient(CommunicatorClient client) throws ClientNotFoundException {
        if (this.connectedClients.contains(client)) {
            this.connectedClients.remove(client);
        }
        else {
            throw new ClientNotFoundException(client);
        }
    }

    @Override
    public List<CommunicatorClient> getConnectedClients() {
        return new ArrayList<>(connectedClients);
    }

    @Override
    public void sendMessage(String message, CommunicatorClient client) throws ClientNotFoundException {
        if (this.connectedClients.contains(client)) {
            client.receiveMessage(message);
        }
        else {
            throw new ClientNotFoundException(client);
        }
    }

    @Override
    public void broadcastMessage(String message) {
        for (CommunicatorClient client : connectedClients) {
            client.receiveMessage(message);
        }
    }
}
