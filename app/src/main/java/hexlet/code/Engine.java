package hexlet.code;

import java.io.IOException;
import java.util.Scanner;

public class Engine {
    public static final int COUNT_OF_ROUNDS = 3;
    private static String userName;
    private static boolean gameWin = true;
    private static Scanner sc = new Scanner(System.in);


    public static void game(String rule, String[] data) throws IOException {
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        userName = sc.nextLine().trim();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rule);
        for (int i = 0; i < data.length & gameWin; i++) {
            askQuestion(data[i]);
            checkAnswer(getAnswer(), data[++i]);
        }
        end();
    }


    private static <T> void askQuestion(T question) {
        System.out.printf("\nQuestion: " + question);
    }

    private static String getAnswer() {
        System.out.print("\nYour answer: ");
        String answer = sc.nextLine();
        while (answer.isEmpty()) {
            System.out.print("Your answer is empty. Please enter answer: ");
            answer = sc.nextLine();
        }
        return answer.trim().toLowerCase();
    }

    private static void end() {
        if (gameWin) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    private static void checkAnswer(String answer, String trueAnswer) {
        if (answer.equals(trueAnswer)) {
            System.out.println("Correct!");
            gameWin = true;
        } else {
            System.out.printf("\n'" + answer + "' is wrong answer ;(. Correct answer was '" + trueAnswer + "'\n");
            gameWin = false;
        }
    }
}
