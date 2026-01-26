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
           Calculator calc = new Calculator();
           this.socket = socket;
           try{
              out = new DataOutputStream(this.socket.getOutputStream());
              in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
              operation();
            }
            catch(IOException e){
                System.out.println("Error in client handler: " + e.getMessage());
           }
        }
    public void operation(){   
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
                catch(NumberFormatException e){
                    System.out.println("Invalid number format received from client.");
                    try{
                        out.writeUTF("Error: Invalid number format.");
                        out.flush();
                    }
                    catch(IOException ioEx){
                        System.out.println("Error sending error message to client: " + ioEx.getMessage());
                    }
                }
                catch(IOException e){
                    System.out.println("Client disconnected.");
                }
                catch(Exception e){
                    System.out.println("An error occurred: " + e.getMessage());
                }
                finally{
                    System.out.println("closing connection with client");
                    try{
                        socket.close();
                        in.close();
                    }
                    catch(IOException e){System.out.println(e);}
                    }
                }
            }
        }