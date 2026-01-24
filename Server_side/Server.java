package Server_side;   
import java.net.*;
import java.io.*;
import Calculator.Calculator;
public class Server {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;
   // private BufferedReader input;
    public Server(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("server started");
            System.out.println("Waiting for the client........");

            socket = server.accept();
            System.out.println("client accepted");
            
            out = new DataOutputStream(socket.getOutputStream());
          //  input = new BufferedReader(new InputStreamReader(System.in));
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String[] line = new String[2];
            // String send = "";
            while(true){
                try{
                    line = in.readUTF().split("\\s+");
                    int n1 = Integer.parseInt(line[0]);
                    char op = line[1].charAt(0);
                    int n2 = Integer.parseInt(line[2]);
                    double result = calculate(n1,n2,op);
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
        public double calculate(int n1, int n2, char op){
            Calculator calc = new Calculator();
            double result = 0;
            switch(op){
                case '+':
                    result = calc.add(n1,n2);
                    break;
                case '-':
                    result = calc.sub(n1,n2);
                    break;
                case '*':
                    result = calc.mult(n1,n2);
                    break;
                case '/':
                    result = calc.div(n1,n2);
                    break;
                default:
                    System.out.println("invalid operation");
            }
            return result;
        }
        public static void main(String args[]){
            Server server = new Server(8080);
        }
    }
    

