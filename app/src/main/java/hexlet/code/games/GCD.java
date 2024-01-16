package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class GCD {
    public static void startGame() throws IOException {
        String rule = "Find the greatest common divisor of given numbers.";
        int sizeOfMass = COUNT_OF_ROUNDS * 2;
        String[] data = new String[sizeOfMass];
        for (int i = 0; i < sizeOfMass; i++) {
            int number1 = Util.random();
            int number2 = Util.random();
            int trueAnswer = gcd(number1, number2);
            String question = number1 + " " + number2;
            data[i] = question;
            data[++i] = String.valueOf(trueAnswer);
        }
        Engine.game(rule, data);
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
