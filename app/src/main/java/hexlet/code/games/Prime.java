package hexlet.code.games;

import java.io.IOException;
import java.util.stream.IntStream;

import static hexlet.code.Engine.*;

public class Prime {
	public static void startGame() throws IOException {
		start("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int number = random(1, 1000);
			askQuestion(number);
			checkAnswer(getAnswer(), getTrueAnswer(number));
		}
	}

	private static boolean isPrime(final int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	private static String getTrueAnswer(int number) {
		return isPrime(number) ? "yes" : "no";
	}
}
