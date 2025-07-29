package src;

import java.awt.event.*;
import javax.swing.*;

public class mainEventListener implements ActionListener {
    private JTextField answerField;
    private JLabel flagLabel;

    public void setAnswerField(JTextField field) {
        this.answerField = field;
    }

    public void setFlagLabel(JLabel label) {
        this.flagLabel = label;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }
}
