package src;

import java.awt.Image;
import java.io.File;
import java.util.Random;
import javax.swing.*;

public class Game {

    private String[] flagPaths;
    private String assetsDir;
    private long gameSeed;

    private JFrame rootFrame;
    private JLabel flagLabel;
    
    public void run() {
        setupGUI();
        this.rootFrame.pack();
        this.rootFrame.setVisible(true);
    }

    private void setupGUI() {
        this.assetsDir = getAssetsDir();
        this.flagPaths = getFlagPaths();
        this.gameSeed = System.currentTimeMillis();

        // Root Window
        this.rootFrame = new JFrame("Flag Quiz");
        this.rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Game Panel
        JPanel gamePanel = new JPanel();
        this.rootFrame.add(gamePanel);

        // Components
        this.flagLabel = new JLabel();
        nextFlag(this.gameSeed);

        JLabel answerLabel = new JLabel("Answer:");
        JTextField answerField = new JTextField(20);
        JButton answerButton = new JButton("Submit");

        gamePanel.add(this.flagLabel);
        gamePanel.add(answerLabel);
        gamePanel.add(answerField);
        gamePanel.add(answerButton);
    }

    private String[] getFlagPaths() {
        File assets = new File(this.assetsDir);
        String[] filePaths = assets.list();
        return filePaths;
    }

    private String getAssetsDir() {
        return new File(".").getAbsolutePath() + "/assets/";
    }

    private void nextFlag(long seed) {
        int randIdx = new Random(seed).nextInt(0, this.flagPaths.length);
        ImageIcon flagImage = new ImageIcon(this.assetsDir + this.flagPaths[randIdx]);
        flagImage.setImage(flagImage.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
        this.flagLabel.setIcon(flagImage);
    }
}
