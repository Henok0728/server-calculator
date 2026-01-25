package Client_side.client_ui;
import javax.swing.*;
import java.awt.*;

public class UI extends JFrame{
    public UI(){
    this.setTitle("Calculator Client");
    this.setSize(400,500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    }

    
    

    
public static void main(String args[]){
    new UI();
}
}