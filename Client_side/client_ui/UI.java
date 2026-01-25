package Client_side.client_ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener {

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

        JScrollPane inputScroll = new JScrollPane(inputArea);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            String inputText = inputArea.getText().trim();
            if (!inputText.isEmpty()) {
                displayArea.append("You: " + inputText + "\n");
                inputArea.setText("");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}
