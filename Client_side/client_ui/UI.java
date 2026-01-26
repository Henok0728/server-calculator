package Client_side.client_ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.io.*;


import Client_side.Client;

import java.awt.event.*;

public class UI extends JFrame implements ActionListener {
    private JButton[] buttons;
    private JTextArea inputArea;
    private JTextArea displayArea;
    private Client client;
    private ImageIcon icon;
    

    public UI() {
        try{
            this.client = new Client("127.0.0.1",8080);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(this, "Unable to connect to server: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);

        }
        this.setTitle("Client Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));


        this.icon = new ImageIcon("favicon/logo.png");
        Image image = icon.getImage();

        this.setIconImage(image);

        // Display area (output)
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setBackground(Color.BLACK);
        displayArea.setForeground(Color.GREEN);
        displayArea.setFocusable(false);
      
        displayArea.setBorder(new TitledBorder("Display Area"));

        JScrollPane displayScroll = new JScrollPane(displayArea);
        add(displayScroll, BorderLayout.CENTER);

        // Input area
        inputArea = new JTextArea(4, 30);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                e.consume();
                String text = inputArea.getText();
                if (!text.trim().isEmpty()) {
                    displayArea.append("You: " + text.trim() + "\n");
                    implementation(text.trim());
                }
                inputArea.setText("");
            }
        }
    });

        JScrollPane inputScroll = new JScrollPane(inputArea);
        
        buttons = new JButton[2];
        buttons[0] = new JButton("Send");
        buttons[1] = new JButton("CloseConnection");
        
    
        for (JButton button: buttons){
            button.addActionListener(this);
            button.setFocusable(false);
            button.setFont(new Font("monospace", Font.BOLD, 12));
            button.setBackground(new Color(12, 237, 237));
            button.setForeground(Color.BLACK);
        }
        

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(new TitledBorder("Input Area"));
        inputPanel.add(inputScroll, BorderLayout.CENTER);
        inputPanel.add(buttons[0], BorderLayout.EAST);
        inputPanel.add(buttons[1], BorderLayout.WEST);

        add(inputPanel, BorderLayout.SOUTH);

        this.pack();              
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(500,500);
        this.setResizable(false);
    }
    public void implementation(String message){
        try{
           
            String response = client.sendAndReceiveData(message);
            displayArea.append("Server: " + response + "\n");
            
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(this, "Unable to connect to server: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "UNEXPECTED ERROR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            String inputText = inputArea.getText().trim();
            if (!inputText.isEmpty()) {
                displayArea.append("You: " + inputText + "\n");
                inputArea.setText("");
                implementation(inputText);
            }
        }
        else if (e.getSource() == buttons[1]){
            try{
                client.close();
                displayArea.append("Connection closed.\n");
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Error closing connection: " + ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception ey){
                JOptionPane.showMessageDialog(this, "UNEXPECTED ERROR: " + ey.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}
