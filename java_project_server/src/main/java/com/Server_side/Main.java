package com.Server_side;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.setup(); // MUST be inside main()

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FlatLaf Test");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
