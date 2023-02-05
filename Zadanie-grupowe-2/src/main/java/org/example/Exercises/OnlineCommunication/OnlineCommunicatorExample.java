package org.example.Exercises.OnlineCommunication;

public class OnlineCommunicatorExample {
    public static void example() {
        CommunicatorServer server = new Server();
        CommunicatorClient samsung = new Smartphone("Mateusz");
        CommunicatorClient xiaomi = new Smartphone("Łukasz");
        CommunicatorClient motorola = new Smartphone("Anna");
        CommunicatorClient iPhone = new Smartphone("Dominik");
        CommunicatorClient pc = new Computer(1999);

        server.registerClient(samsung);
        server.registerClient(xiaomi);
        server.registerClient(motorola);
        server.registerClient(iPhone);
        server.registerClient(pc);

        server.broadcastMessage("Hello, World!");
    }
}
