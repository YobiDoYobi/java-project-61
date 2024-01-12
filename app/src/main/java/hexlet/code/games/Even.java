package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.*;

public class Even {
	public static void startGame() throws IOException {
		start("Answer 'yes' if the number is even, otherwise answer 'no'.");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int number = random();
			askQuestion(number);
			gameWin = checkAnswer(getAnswer(), getTrueAnswer(number));
		}
		end(gameWin);
	}

	private static String getTrueAnswer(int number) {
		return number % 2 == 0 ? "yes" : "no";
	}
}
