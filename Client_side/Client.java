package Client_side;

import java.net.*;
import java.io.*;


public class Client{
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public Client(String address, int port) throws IOException {
        socket = new Socket(address, port);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    public String sendAndReceiveData(String data) throws IOException {
        out.writeUTF(data);
        out.flush();                
        return in.readUTF();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
