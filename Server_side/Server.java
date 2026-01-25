package Server_side;   
import java.net.*;
import java.io.*;
import Implementation_side.Calculator;



public class Server {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;
    public Server(int port){
        try{
          
            Calculator calc = new Calculator();
            System.out.println("server started");
            System.out.println("Waiting for the client........");
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println("client accepted");
           
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String[] line = new String[2];
            while(true){
                try{
                    line = in.readUTF().split("\\s+");
                    double n1 = Double.parseDouble(line[0]);
                    char op = line[1].charAt(0);
                    double n2 = Double.parseDouble(line[2]);
                    Number result = calc.calculate(n1,n2,op);
                    System.out.println("client says: "+n1+" "+op+" "+n2);
                    out.writeUTF("result is: "+result);
                    out.flush();
                }
                catch(IOException e){
                    System.out.println(e);
                    break;
                }
            }
            System.out.println("closing connection");
            socket.close();
            in.close();   
        }
        catch(IOException e){System.out.println(e);}
    }
        public static void main(String args[]){
            Server server = new Server(8080);
        }
    }
    

