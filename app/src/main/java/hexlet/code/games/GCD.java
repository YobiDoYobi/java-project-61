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


public class GCD {
    public static void startGame() throws IOException {
        start("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < COUNT_OF_ROUNDS & gameWin; i++) {
            int number1 = random(0, 100);
            int number2 = random(0, 100);
            int trueAnswer = gcd(number1, number2);
            askQuestion(number1 + " " + number2);
            checkAnswer(getAnswer(), String.valueOf(trueAnswer));
        }
        end();
    }

    private static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
