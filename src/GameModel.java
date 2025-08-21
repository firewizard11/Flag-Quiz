package src;

import java.io.*;
import java.util.*;

public class GameModel {
    private int score;
    private int roundCount;
    final private String flagFolder;  
    private String currentFlag;
    final private ArrayList<String> flagPaths;

    public GameModel() {
        score = 0;
        roundCount = 0;

        flagFolder = new File("flags").getAbsolutePath();

        flagPaths = new ArrayList<>();
        flagPaths.addAll(Arrays.asList(new File(flagFolder).list()));
        Collections.shuffle(flagPaths);

        currentFlag = new String();
    }

    public void incrementScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementRoundCount() {
        this.roundCount++;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    public void setNextFlag() {
        this.currentFlag = this.flagPaths.get(this.roundCount);
    }

    public String getCurrentFlagPath() {
        return this.flagFolder + "\\" + this.currentFlag;
    }

    public boolean isAnswerCorrect(String answer) {
        return this.currentFlag.equalsIgnoreCase(answer);
    }
}
