package src;

import javax.swing.*;

public class GameView {
    final private JPanel gamePanel;
    final private JFrame rootWindow;
    final private JLabel scoreLabel;
    final private JLabel flagFrame;
    final private JLabel answerLabel;
    final private JTextField answerBox;
    protected JButton submitButton;

    public GameView() {
        rootWindow = new JFrame();
        rootWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootWindow.setSize(800, 600);

        gamePanel = new JPanel();
        scoreLabel = new JLabel();
        flagFrame = new JLabel();
        answerLabel = new JLabel("Answer:");
        answerBox = new JTextField(20);

        submitButton = new JButton("Submit");
        rootWindow.getRootPane().setDefaultButton(submitButton);

        rootWindow.add(gamePanel);

        gamePanel.add(scoreLabel);
        gamePanel.add(flagFrame);
        gamePanel.add(answerLabel);
        gamePanel.add(answerBox);
        gamePanel.add(submitButton);

        rootWindow.setVisible(true);
    }

    public void updateScore(int score) {
        this.scoreLabel.setText("Score: " + score);
    }

    public void updateFlag(String flagPath) {
        this.flagFrame.setIcon(new ImageIcon(flagPath));
    }

    public String getUserInput() {
        return this.answerBox.getText();
    }

    public void clearAnswerBox() {
        this.answerBox.setText("");
    }
}
