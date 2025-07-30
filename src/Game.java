package src;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Game {

    // State Variables
    private String assetsDir;
    private long gameSeed;
    private int score;
    private int maxScore;
    private ArrayList<String> flagPaths;

    // GUI Components
    private JFrame rootFrame;
    private JPanel gamePanel;
    private JLabel scoreLabel;
    private JLabel flagLabel;
    private JLabel answerLabel;
    private JTextField answerField;
    private JButton answerButton;


    public void run() {
        // Initialize State and Components
        setupGame();
        setupGUI();

        // Start Game
        this.rootFrame.pack();
        this.rootFrame.setVisible(true);
    }

    private void setupGame() {
        getAssetsDir();
        getFlagPaths();
        this.gameSeed = System.currentTimeMillis();
        this.maxScore = this.flagPaths.size();
        this.score = 0;
    }

    private void setupGUI() {
        this.rootFrame = new JFrame("Flag Quiz");
        this.rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gamePanel = new JPanel();
        this.rootFrame.add(this.gamePanel);

        this.scoreLabel = new JLabel(Integer.toString(this.score) + '/' + Integer.toString(this.maxScore));
        this.flagLabel = new JLabel();
        updateFlag(this.gameSeed);
        this.answerLabel = new JLabel("Answer:");
        this.answerField = new JTextField(20);

        this.answerButton = new JButton("Submit");
        this.answerButton.addActionListener(event -> {
                submitHandler();
        });

        this.gamePanel.add(this.scoreLabel);
        this.gamePanel.add(this.flagLabel);
        this.gamePanel.add(this.answerLabel);
        this.gamePanel.add(this.answerField);
        this.gamePanel.add(this.answerButton);
    }

    
    private void getAssetsDir() {
        this.assetsDir =  new File(".").getAbsolutePath() + "/assets/";
    }

    private void getFlagPaths() {
        File assets = new File(this.assetsDir);
        ArrayList<String> filePaths = new ArrayList<>(Arrays.asList(assets.list()));
        this.flagPaths = filePaths;
    }

    private void updateFlag(long seed) {
        int randIndex = new Random(seed).nextInt(0, this.flagPaths.size());

        ImageIcon flagImage = new ImageIcon(this.assetsDir + this.flagPaths.get(randIndex));
        flagImage.setImage(flagImage.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
        this.flagLabel.setIcon(flagImage);
        this.flagPaths.remove(randIndex);
    }

    private void submitHandler() {
        String answer = this.answerField.getText();
        String prepAnswer = prepareAnswer(answer);
        String currentFlag = this.flagLabel.getIcon().toString();
        String prepCurrentFlag = currentFlag.substring(currentFlag.length() - prepAnswer.length());

        if (prepareAnswer(answer).contentEquals(prepCurrentFlag)) {
            this.score++;
            this.scoreLabel.setText(Integer.toString(this.score));

            if (this.score < this.maxScore) {
                updateFlag(this.gameSeed);
            } else {
                this.flagLabel.setIcon(new ImageIcon("win.png"));
            }
        }

        this.answerField.setText("");
    }

    private String prepareAnswer(String answer) {
        String prep_answer = answer.replace(" ", "_").toLowerCase();
        return prep_answer + ".png";
    }
}
