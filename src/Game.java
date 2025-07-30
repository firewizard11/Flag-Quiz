package src;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Random;
import javax.swing.*;

public class Game {

    private String[] flagPaths;
    private String assetsDir;
    private long gameSeed;
    private int score;

    private JFrame rootFrame;
    private JLabel flagLabel;
    private JTextField answerField;
    private JLabel scoreLabel;
    
    public void run() {
        setupGUI();
        this.rootFrame.pack();
        this.rootFrame.setVisible(true);
    }

    private void setupGUI() {
        this.assetsDir = getAssetsDir();
        this.flagPaths = getFlagPaths();
        this.gameSeed = System.currentTimeMillis();
        this.score = 0;

        // Root Window
        this.rootFrame = new JFrame("Flag Quiz");
        this.rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Game Panel
        JPanel gamePanel = new JPanel();
        this.rootFrame.add(gamePanel);

        // Components
        this.scoreLabel = new JLabel(Integer.toString(this.score));

        this.flagLabel = new JLabel();
        nextFlag(this.gameSeed);

        JLabel answerLabel = new JLabel("Answer:");
        this.answerField = new JTextField(20);

        JButton answerButton = new JButton("Submit");
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitHandler();
            }
        });

        gamePanel.add(this.scoreLabel);
        gamePanel.add(this.flagLabel);
        gamePanel.add(answerLabel);
        gamePanel.add(this.answerField);
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

    private void submitHandler() {
        String answer = this.answerField.getText();
        String prepAnswer = prepareAnswer(answer);
        String currentFlag = this.flagLabel.getIcon().toString();
        String prepCurrentFlag = currentFlag.substring(currentFlag.length() - prepAnswer.length());

        if (prepareAnswer(answer).contentEquals(prepCurrentFlag)) {
            System.out.println("Right Answer");
            this.score++;
            this.scoreLabel.setText(Integer.toString(this.score));
            nextFlag(this.gameSeed);
        }

        this.answerField.setText("");
    }

    private String prepareAnswer(String answer) {
        String prep_answer = answer.replace(" ", "_").toLowerCase();
        return prep_answer + ".png";
    }
}
