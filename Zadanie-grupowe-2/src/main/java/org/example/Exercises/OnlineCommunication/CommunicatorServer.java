package org.example.Exercises.OnlineCommunication;

import java.util.List;

public interface CommunicatorServer {
    List<CommunicatorClient> getConnectedClients();
    void sendMessage(String message, CommunicatorClient client) throws ClientNotFoundException;
    void broadcastMessage(String message);
    void registerClient(CommunicatorClient client);
    void unregisterClient(CommunicatorClient client) throws ClientNotFoundException;
}
