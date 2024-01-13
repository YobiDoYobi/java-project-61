package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Engine {
    public static final int COUNT_OF_ROUNDS = 3;
    private static String userName;
    public static boolean gameWin = true;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void start(String rule) throws IOException {
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        userName = reader.readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rule);
    }

    public static int random(int start, int end) {
        return (int) (Math.random() * end + start);
    }

    public static <T> void askQuestion(T question) {
        System.out.printf("\nQuestion: " + question);
    }

    public static String getAnswer() throws IOException {
        System.out.print("\nYour answer: ");
        String answer = reader.readLine().toLowerCase(Locale.ROOT);
        while (answer.isEmpty()) {
            System.out.print("Your answer is empty. Please enter answer: ");
            answer = reader.readLine().toLowerCase(Locale.ROOT);
        }
        return answer;
    }

    public static void end() {
        if (gameWin) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    public static void checkAnswer(String answer, String trueAnswer) {
        if (answer.equals(trueAnswer)) {
            System.out.println("Correct!");
            gameWin = true;
        } else {
            System.out.printf("\n'" + answer + "' is wrong answer ;(. Correct answer was '" + trueAnswer + "'\n");
            gameWin = false;
        }
    }
}
