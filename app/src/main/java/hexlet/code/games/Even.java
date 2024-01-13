package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.*;

public class Even {
	public static void startGame() throws IOException {
		start("Answer 'yes' if the number is even, otherwise answer 'no'.");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int number = random(0, 100);
			askQuestion(number);
			checkAnswer(getAnswer(), getTrueAnswer(number));
		}
		end();
	}

	private static String getTrueAnswer(int number) {
		return number % 2 == 0 ? "yes" : "no";
	}
}
