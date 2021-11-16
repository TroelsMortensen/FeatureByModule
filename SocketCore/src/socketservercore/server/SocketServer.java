package socketservercore.server;

import socketservercore.tos.Request;
import socketservercore.tos.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {

    public interface ControllerConstructor {
        SocketController create();
    }

    private final Map<String, ControllerConstructor> controllers = new HashMap<>();

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2710);
        System.out.println("Server started");
        while (true) {
            Socket socketToClient = serverSocket.accept();
            Thread t = new Thread(() -> handleClientRequest(socketToClient));
            t.start();
        }
    }

    public void addController(String name, ControllerConstructor controller) {
        if (controllers.containsKey(name))
            throw new IllegalArgumentException("Controller name '" + name + "' is already in use");
        if (controller == null)
            throw new IllegalArgumentException("Controller cannot be null");

        controllers.put(name, controller);
    }

    private void handleClientRequest(Socket socketToClient) {
        ObjectInputStream inFromClient;
        ObjectOutputStream outToClient;
        try {
            inFromClient = new ObjectInputStream(socketToClient.getInputStream());
            outToClient = new ObjectOutputStream(socketToClient.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Request request = (Request) inFromClient.readObject();
            directToController(outToClient, request);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // can we recover?
        }
    }

    private void directToController(ObjectOutputStream outToClient, Request request) throws IOException {
        if (!controllers.containsKey(request.requestType)) {
            Response response = new Response("Error", "Could not locate controller " + request.requestType);
            outToClient.writeObject(response);
            return;
        }

        try {
            SocketController controller = controllers.get(request.requestType).create();
            Response response = controller.handle(request);
            outToClient.writeObject(response);
        } catch (Exception e) {
            Response response = new Response("Error", e.getMessage());
            outToClient.writeObject(response);
        }
    }
}
