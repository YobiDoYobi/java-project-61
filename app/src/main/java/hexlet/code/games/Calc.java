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

public class Calc {

    public static void startGame() throws IOException {
        start("What is the result of the expression?");
        for (int i = 0; i < COUNT_OF_ROUNDS & gameWin; i++) {
            int number1 = random(0, 100);
            int number2 = random(0, 100);
            int trueAnswer = 0;
            int operation = random(0, 3); //0 +, 1 -, 2 *
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
