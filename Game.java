import java.util.*;
import java.io.*;

public class Game {
    public static void main(String[] args) {
        // Initialize Game
        int score = 0;
        int roundCounter = 0;
        String[] flagPaths = new File("./flags/").list();
        int roundMax = flagPaths.length;
        long seed = System.currentTimeMillis();
        Random genIdx = new Random(seed);
        Scanner userAnswer = new Scanner(System.in);

        String currentFlag;
        String answer;

        // Game Loop
        while (true) {
            currentFlag = flagPaths[genIdx.nextInt(roundMax)];

            System.out.println("Score: " + score);
            System.out.println("currentFlag: " + currentFlag);

            System.out.print("Answer: ");
            answer = userAnswer.nextLine();

            if (answer.compareTo(currentFlag) == 0) {
                score++;
            }

            roundCounter++;

            if (roundCounter == roundMax) {
                break;
            }
        }

        System.out.printf("Final Score: %d / %d\n", score, roundMax);
        userAnswer.close();
    }
}