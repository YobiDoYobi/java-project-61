package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;

public class Calc {

    public static void startGame() throws IOException {
        final int startRangeOperation = 0;
        final int endRangeOperation = 3;
        String rule = "What is the result of the expression?";
        int sizeOfMass = COUNT_OF_ROUNDS * 2;
        String[] data = new String[sizeOfMass];
        for (int i = 0; i < sizeOfMass; i++) {
            int number1 = Util.random();
            int number2 = Util.random();
            int trueAnswer = 0;
            int operation = Util.random(startRangeOperation, endRangeOperation); //0 +, 1 -, 2 *
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
            data[i] = question;
            data[++i] = String.valueOf(trueAnswer);
        }
        Engine.game(rule, data);
    }
}
