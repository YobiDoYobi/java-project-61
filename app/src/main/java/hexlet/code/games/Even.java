package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Even {
    public static void startGame() throws IOException {
        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        int sizeOfMass = COUNT_OF_ROUNDS * 2;
        String[] data = new String[sizeOfMass];
        for (int i = 0; i < sizeOfMass; i++) {
            int question = Util.random();
            data[i] = String.valueOf(question);
            data[++i] = getTrueAnswer(question);
        }
        Engine.game(rule, data);
    }

    private static String getTrueAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
