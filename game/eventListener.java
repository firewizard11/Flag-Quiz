package game;

import javax.swing.*;
import java.awt.event.*;

public class eventListener implements ActionListener {

    private JTextField answerField;

    public void setAnswerField(JTextField field) {
        this.answerField = field;
    }

    public void actionPerformed(ActionEvent event) {
        String answer = this.answerField.getText();
        System.out.println(answer);
        this.answerField.setText("");
    }
}
