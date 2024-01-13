package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.start;
import static hexlet.code.Engine.getAnswer;
import static hexlet.code.Engine.checkAnswer;
import static hexlet.code.Engine.random;
import static hexlet.code.Engine.COUNT_OF_ROUNDS;
import static hexlet.code.Engine.gameWin;
import static hexlet.code.Engine.end;

public class Progression {
    public static void startGame() throws IOException {
        start("What number is missing in the progression?");
        for (int i = 0; i < COUNT_OF_ROUNDS & gameWin; i++) {
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
        end();
    }
}
