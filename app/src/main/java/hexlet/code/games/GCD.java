package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class GCD {
    public static void startGame() throws IOException {
        String rule = "Find the greatest common divisor of given numbers.";
        ArrayList<HashMap<String, String>> data = new ArrayList<>(COUNT_OF_ROUNDS);
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            HashMap<String, String> round = new HashMap<>();
            int number1 = Util.random();
            int number2 = Util.random();
            int trueAnswer = gcd(number1, number2);
            String question = number1 + " " + number2;
            round.put("Question", question);
            round.put("Answer", String.valueOf(trueAnswer));
            data.add(round);
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
