package src;

import javax.swing.*;

public class GUI {

    private JFrame rootFrame;

    public void run() {
        setup();
        this.rootFrame.pack();
        this.rootFrame.setVisible(true);
    }

    private void setup() {
        // Root Window
        this.rootFrame = new JFrame("Flag Quiz");
        this.rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Game Panel
        JPanel gamePanel = new JPanel();
        this.rootFrame.add(gamePanel);

        // Components
        JLabel flagLabel = new JLabel();
        JLabel answerLabel = new JLabel("Answer:");
        JTextField answerField = new JTextField(20);
        JButton answerButton = new JButton("Submit");

        gamePanel.add(flagLabel);
        gamePanel.add(answerLabel);
        gamePanel.add(answerField);
        gamePanel.add(answerButton);
    }
}
