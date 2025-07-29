package src;

import java.io.File;
import javax.swing.*;

public class Game {

    private JFrame rootFrame;
    private String[] flagPaths;

    public void run() {
        this.flagPaths = getFlagPaths();
        setupGUI();
        this.rootFrame.pack();
        this.rootFrame.setVisible(true);
    }

    private void setupGUI() {
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

    private String[] getFlagPaths() {
        String currentDir = new File(".").getAbsolutePath();
        File assets = new File(currentDir + "/assets/");
        String[] filePaths = assets.list();
        return filePaths;
    }
}
