package Client_side.client_ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class UI extends JFrame {

    private JButton sendButton;
    private JTextArea inputArea;
    private JTextArea displayArea;

    public UI() {
        this.setTitle("Client Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));

        // Display area (output)
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setBorder(new TitledBorder("Display Area"));

        JScrollPane displayScroll = new JScrollPane(displayArea);
        add(displayScroll, BorderLayout.CENTER);

        // Input area
        inputArea = new JTextArea(4, 30);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        JScrollPane inputScroll = new JScrollPane(inputArea);

        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(new TitledBorder("Input Area"));
        inputPanel.add(inputScroll, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        this.pack();              // Let layout decide size
        this.setLocationRelativeTo(null); // Center window
        this.setVisible(true);
        this.setSize(500,500);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}
