package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.*;

public class GCD {
	public static void startGame() throws IOException {
		start("Find the greatest common divisor of given numbers.");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int number1 = random(0, 100);
			int number2 = random(0, 100);
			int trueAnswer = gcd(number1, number2);
			askQuestion(number1 + " " + number2);
			checkAnswer(getAnswer(), String.valueOf(trueAnswer));
		}
		end();
	}

	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
}
