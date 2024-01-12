package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Even {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void startGame() throws IOException {
		System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
		String name = reader.readLine();
		System.out.println("Hello, " + name + "!"
				+ "\nAnswer 'yes' if the number is even, otherwise answer 'no'.");
		boolean gameWin = true;
		for (int i = 0; i < 3 & gameWin; i++) {
			gameWin = game();
		}
		if (gameWin) {
			System.out.println("Congratulations, " + name + "!");
		} else {
			System.out.println("Let's try again, " + name + "!");
		}
	}

	private static String getTrueAnswer(int number) {
		return number % 2 == 0 ? "yes" : "no";
	}

	private static int random() {
		return (int) (Math.random() * 100);
	}

	private static boolean game() throws IOException {
		int number = random();
		boolean gameContinue = true;
		String trueAnswer = getTrueAnswer(number);
		System.out.printf("\nQuestion: " + number);
		System.out.print("\nYour answer: ");
		String answer = reader.readLine().toLowerCase(Locale.ROOT);
		while (answer.isEmpty()) {
			System.out.print("Your answer is empty. Please enter again. Your answer: ");
			answer = reader.readLine().toLowerCase(Locale.ROOT);
		}
		if (answer.equals(trueAnswer)) {
			System.out.println("Correct!");
		} else {
			System.out.printf("\n'" + answer + "' is wrong answer ;(. Correct answer was '" + trueAnswer + "'\n");
			gameContinue = false;
		}
		return gameContinue;
	}
}
