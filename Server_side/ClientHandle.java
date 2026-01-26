package Server_side;

import Implementation_side.Calculator;
import java.net.*;
import java.io.*;

public class ClientHandle extends Thread {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Calculator calc;

    public ClientHandle(Socket socket) {
        this.socket = socket;
        this.calc = new Calculator();
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String input = in.readUTF(); 
                String[] parts = input.split("\\s+");

                if (parts.length != 3) {
                    out.writeUTF("Error: Use format -> number operator number");
                    continue;
                }

                double n1 = Double.parseDouble(parts[0]);
                char op = parts[1].charAt(0);
                double n2 = Double.parseDouble(parts[2]);

                Number result = calc.calculate(n1, n2, op);

                System.out.println("Client " + socket.getPort() +
                        ": " + n1 + " " + op + " " + n2);

                out.writeUTF("Result is: " + result);
                out.flush();
            }

        } catch (EOFException e) {
            System.out.println("Client disconnected: " + socket.getPort());
        } catch (NumberFormatException e) {
            sendError("Invalid number format.");
        } catch (IOException e) {
            System.out.println("I/O error with client: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    private void sendError(String msg) {
        try {
            out.writeUTF("Error: " + msg);
            out.flush();
        } catch (IOException ignored) {}
    }

    private void closeResources() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("Connection closed with client.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
