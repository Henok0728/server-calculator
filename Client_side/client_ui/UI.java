package Client_side.client_ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.text.*;


interface UIComponents{
    JButton sendButton = new JButton("Send");
    JTextArea inputArea = new JTextArea();
    JTextArea outputArea = new JTextArea();
}

public class UI extends JFrame implements UIComponents{
    private JButton sendButton;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JPanel panelText;
    private JPanel ButtonPanel;

    public UI(){
    this.setTitle("Calculator Client");
    this.setSize(400,500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLayout(new GridLayout(2,1));
    
    inputArea = new JTextArea();
    outputArea = new JTextArea();
    sendButton = new JButton("Send");
    button.setSize(100,50);

    panelText = new JPanel();
    panelText.setLayout(new GridLayout(1,2));
    panelText.add(inputArea);
    panelText.add(outputArea);

    ButtonPanel = new JPanel();
    ButtonPanel.add(sendButton);
    ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


    this.add(panelText);
    this.add(ButtonPanel);
    }

public static void main(String args[]){
    new UI();
}
}