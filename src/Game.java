package src;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Game {
    private int score;
    private int roundCounter;
    private int roundMax;
    private Random genIdx;
    private String[] flagPaths;

    private JFrame rootWindow;
    private JPanel gamePanel;
    private JLabel scoreLabel;
    private JLabel flagFrame;
    private JTextField answerBox;
    private JButton answerButton;


    public void guiRun() {
        // Initiates variables and components then starts
        gameInit();
        guiInit();
        this.rootWindow.setVisible(true);
    }

    
    private void gameInit() {
        // Initiates Game state variables
        long seed = System.currentTimeMillis();

        this.score = 0;
        this.roundCounter = 0;
        this.flagPaths = new File("./flags/").list();
        this.roundMax = flagPaths.length;
        this.genIdx = new Random(seed);
    }

    private void guiInit() {
        // Initiates and configures Swing components
        this.rootWindow = new JFrame("Flag Quiz");
        this.rootWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.rootWindow.setSize(800, 600);
        this.rootWindow.setLocationRelativeTo(null);

        this.gamePanel = new JPanel();

        this.scoreLabel = new JLabel();
        updateScore();
        this.flagFrame = new JLabel();
        nextFlag();

        JLabel answerLabel = new JLabel("Answer:");
        this.answerBox = new JTextField(20);

        answerLabel.setLabelFor(this.answerBox);
        this.answerButton = new JButton("Submit");
        this.answerButton.addActionListener(e -> {
            updateGame();
        });

        this.rootWindow.add(this.gamePanel);
        this.gamePanel.add(this.scoreLabel);
        this.gamePanel.add(this.flagFrame);
        this.gamePanel.add(answerLabel);
        this.gamePanel.add(this.answerBox);
        this.gamePanel.add(this.answerButton);
    }



    private void updateGame() {
        // Contains the game logic
        if (isCorrect()) {
            this.score++;
        }

        nextFlag();
        this.answerBox.setText("");
        this.roundCounter++;
        updateScore();

        if (this.roundCounter == this.roundMax) {
            this.flagFrame.setIcon(null);
            this.flagFrame.setText("FINISHED");
        }
    }

    private void nextFlag() {
        // Updates the flag image
        this.flagFrame.setIcon(new ImageIcon("./flags/" + this.flagPaths[this.genIdx.nextInt(this.roundMax)]));
    }

    private void updateScore() {
        // Updates the score label
        this.scoreLabel.setText(this.score + " / " + this.roundMax);
    }

    private boolean isCorrect() {
        // Checks if the user's answer is correct
        String answer = this.answerBox.getText();
        String prepped_answer = answer.toLowerCase().replace(" ", "").concat(".png");
        String currentFlag = this.flagFrame.getIcon().toString();
        String prepped_flag = currentFlag.substring("./flags/".length()).replace("_", "").toLowerCase();
        System.out.println(currentFlag + "\n" + prepped_flag);
        System.out.println("\n\n" + answer + "\n" + prepped_answer);
        return (prepped_answer.compareTo(prepped_flag) == 0);
    }
}