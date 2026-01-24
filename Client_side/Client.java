package Client_side;
import java.net.*;
import java.io.*;

public class Client {


    private Socket socket;
    private BufferedReader input;
    private DataOutputStream out;
    private DataInputStream in;
    public Client(String address, int port){
        try{
            socket = new Socket(address, port);
            System.out.println("It is connected");

            input = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        } 
        String line = "";
        String recieve ="";
        while (!line.equals("stop")){
            try{
                System.out.println("Enter 2 numbers of with the operation like num1 +-*/ num2");
                line = input.readLine();  
                out.writeUTF(line);
                recieve = in.readUTF();
                System.out.println("server says "+recieve);
                

                
            }  
            catch(IOException e){
                System.out.println(e);
            }
        } 
        }
        public static void main(String[] args) {
            Client client = new Client("127.0.0.1",8080);
        }

}











