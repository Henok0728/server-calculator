package Server_side;   
import java.net.*;
import java.io.*;
import Implementation_side.Calculator;



public class Server {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean running;
    
    public Server (int port){
        try{
            System.out.println("server started on port: "+port);
            System.out.println("Waiting for the client........");
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println("New client accepted");
           
            
    }
        public static void main(String args[]){
            Server server = new Server(8080);
        }
    }
    

