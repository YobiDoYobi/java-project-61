package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.start;
import static hexlet.code.Engine.checkAnswer;
import static hexlet.code.Engine.random;
import static hexlet.code.Engine.COUNT_OF_ROUNDS;
import static hexlet.code.Engine.isGameWin;
import static hexlet.code.Engine.end;
import static hexlet.code.Engine.getAnswerInt;


public class GCD {
    public static void startGame() throws IOException {
        int startRange = 0;
        int endRange = 100;
        start("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < COUNT_OF_ROUNDS & isGameWin(); i++) {
            int number1 = random(startRange, endRange);
            int number2 = random(startRange, endRange);
            int trueAnswer = gcd(number1, number2);
            askQuestion(number1 + " " + number2);
            checkAnswer(getAnswerInt(), trueAnswer);
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
