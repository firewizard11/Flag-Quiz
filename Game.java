
import javax.swing.*;

import game.eventListener;

public class Game {

    public static void main(String[] args) {
        JFrame rootWindow = new JFrame("Flag Quiz");
        rootWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootWindow.setSize(800, 600);
        rootWindow.setLocationRelativeTo(null);

        JPanel gamePanel = new JPanel();
        JLabel answerLabel = new JLabel("Answer:");
        JTextField answerField = new JTextField(20);
        JButton answerButton = new JButton("Submit");

        eventListener buttonListener = new eventListener();
        buttonListener.setAnswerField(answerField);

        answerButton.addActionListener(buttonListener);

        gamePanel.add(answerLabel);
        gamePanel.add(answerField);
        gamePanel.add(answerButton);

        rootWindow.add(gamePanel);
        rootWindow.setVisible(true);
    }
}
