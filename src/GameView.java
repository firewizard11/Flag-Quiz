package src;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

        gamePanel = new JPanel(new GridBagLayout());

        scoreLabel = new JLabel();
        flagFrame = new JLabel();
        answerLabel = new JLabel("Answer:");
        answerBox = new JTextField(20);

        submitButton = new JButton("Submit");
        rootWindow.getRootPane().setDefaultButton(submitButton);

        rootWindow.add(gamePanel);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        gamePanel.add(scoreLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        gamePanel.add(flagFrame, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_END;
        gamePanel.add(answerLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.CENTER;
        gamePanel.add(answerBox, c);

        c.gridx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        gamePanel.add(submitButton, c);

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
