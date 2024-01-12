package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.*;

public class Calc {

	public static void startGame() throws IOException {
		start("What is the result of the expression?");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int number1 = random();
			int number2 = random();
			int trueAnswer = 0;
			int operation = (int) (Math.random() * 3); //0 +, 1 -, 2 *
			String question = switch (operation) {
				case 1 -> {
					trueAnswer = number1 - number2;
					yield number1 + " - " + number2;
				}
				case 2 -> {
					trueAnswer = number1 * number2;
					yield number1 + " * " + number2;
				}
				default -> {
					trueAnswer = number1 + number2;
					yield number1 + " + " + number2;
				}
			};
			askQuestion(question);
			checkAnswer(getAnswer(), String.valueOf(trueAnswer));
		}
		end();
	}
}
