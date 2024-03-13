package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Engine {
    public static final int COUNT_OF_ROUNDS = 3;
    private static Scanner sc = new Scanner(System.in);

    public static void game(String rule, ArrayList<HashMap<String, String>> data) throws IOException {
        System.out.print("\nWelcome to the Brain Games!\nMay I have your name? ");
        String userName = sc.nextLine().trim();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rule);
        for (HashMap<String, String> datum : data) {
            System.out.printf("\nQuestion: " + datum.get("Question"));
            System.out.print("\nYour answer: ");
            String answer = sc.nextLine();
            while (answer.isEmpty()) {
                System.out.print("Your answer is empty. Please enter answer: ");
                answer = sc.nextLine();
            }
            if (answer.trim().toLowerCase().equals(datum.get("Answer"))) {
                System.out.println("Correct!");
            } else {
                System.out.printf("\n'" + answer + "' is wrong answer ;(. Correct answer was '" + datum.get("Answer") + "'\n");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
