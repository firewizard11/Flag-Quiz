import java.util.*;
import java.io.*;

public class Game {
    private int score;
    private int roundCounter;
    private int roundMax;
    private Random genIdx;
    private String[] flagPaths;

    public static void main(String[] args) {
        Game game = new Game();
        game.gameInit();
        game.gameRun();
    }

    private void gameInit() {
        long seed = System.currentTimeMillis();

        this.score = 0;
        this.roundCounter = 0;
        this.flagPaths = new File("./flags/").list();
        this.roundMax = flagPaths.length;
        this.genIdx = new Random(seed);
    }

    private void gameRun() {
        String currentFlag;
        String answer;
        Scanner userAnswer = new Scanner(System.in);

        while (true) {
            currentFlag = this.flagPaths[this.genIdx.nextInt(roundMax)];

            System.out.println("Score: " + this.score);
            System.out.println("currentFlag: " + currentFlag);

            System.out.print("Answer: ");
            answer = userAnswer.nextLine();

            if (answer.compareTo(currentFlag) == 0) {
                this.score++;
            }

            this.roundCounter++;

            if (this.roundCounter == this.roundMax) {
                break;
            }
        }

        System.out.printf("Final Score: %d / %d\n", this.score, this.roundMax);
        userAnswer.close();
    }
}