package Server_side;   
import java.net.*;
import java.io.*;




public class Server {
    private Socket socket;
    private ServerSocket server;
    private boolean running;

    
    public Server (int port){

        running = true;
        
        try{
            while (running){
            server = new ServerSocket(port);
            System.out.println("server started on port: "+port);
            System.out.println("Waiting for the client........");
            socket = server.accept();
            System.out.println("New client connected"); 
            new ClientHandle(socket).start();   
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
           
}
        public static void main(String args[]){
            new Server(8080);
        }
    }
    

