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

public class Calc {

    public static void startGame() throws IOException {
        int startRange = 0;
        int endRange = 100;
        int startRangeOperation = 0;
        int endRangeOperation = 3;
        start("What is the result of the expression?");
        for (int i = 0; i < COUNT_OF_ROUNDS & isGameWin(); i++) {
            int number1 = random(startRange, endRange);
            int number2 = random(startRange, endRange);
            int trueAnswer = 0;
            int operation = random(startRangeOperation, endRangeOperation); //0 +, 1 -, 2 *
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
            checkAnswer(getAnswerInt(), trueAnswer);
        }
        end();
    }
}
