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
    this.setSize(500,500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLayout(new GridLayout(2,1));
    // this.setResizable(false);


    inputArea = new JTextArea();
    inputArea.setLineWrap(true);
    inputArea.setBackground(Color.LIGHT_GRAY);
    outputArea = new JTextArea();
    outputArea.setLineWrap(true);
    outputArea.setEditable(false);
    outputArea.setBackground(Color.LIGHT_GRAY);
    sendButton = new JButton("Send");
    sendButton.setSize(100,50);

    panelText = new JPanel();
    panelText.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
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