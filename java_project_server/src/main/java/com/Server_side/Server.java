package com.Server_side;

import java.net.*;
import java.io.*;
public class Server {

    private ServerSocket server;
    private boolean running;

    public Server(int port) {
        running = true;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (running) {
                System.out.println("Waiting for client...");
                Socket socket = server.accept(); 
                System.out.println("New client connected: " + socket.getInetAddress());
                new ClientHandle(socket).start(); 
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        } finally {
            stopServer();
        }
    }

    private void stopServer() {
        try {
            if (server != null) server.close();
            System.out.println("Server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(8080);
    }
}
