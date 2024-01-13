package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.*;

public class Progression {
	public static void startGame() throws IOException {
		start("What number is missing in the progression?");
		for (int i = 0; i < countOfRounds & gameWin; i++) {
			int startProgression = random(1, 9);
			int stepProgression = random(2, 10);
			int guessNumber = 0;
			int orderNumber = random(1, 10);
			int currNumber = startProgression;
			StringBuilder question = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				if (j != orderNumber) {
					question.append(currNumber).append(" ");
				} else {
					question.append(".. ");
					guessNumber = currNumber;
				}
				currNumber += stepProgression;
			}
			askQuestion(question);
			checkAnswer(getAnswer(), String.valueOf(guessNumber));
		}
	}
}
