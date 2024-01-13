package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.start;
import static hexlet.code.Engine.getAnswerInt;
import static hexlet.code.Engine.checkAnswer;
import static hexlet.code.Engine.random;
import static hexlet.code.Engine.COUNT_OF_ROUNDS;
import static hexlet.code.Engine.isGameWin;
import static hexlet.code.Engine.end;

public class Progression {
    public static void startGame() throws IOException {
        final int startRange = 1;
        final int endRange = 10;
        start("What number is missing in the progression?");
        for (int i = 0; i < COUNT_OF_ROUNDS & isGameWin(); i++) {
            int startProgression = random(startRange, endRange);
            int stepProgression = random(startRange, endRange);
            int guessNumber = 0;
            int orderNumber = random(startRange, endRange);
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
            checkAnswer(getAnswerInt(), guessNumber);
        }
        end();
    }
}
