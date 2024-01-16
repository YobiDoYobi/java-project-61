package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.stream.IntStream;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Prime {
    public static void startGame() throws IOException {
        int sizeOfMass = COUNT_OF_ROUNDS * 2;
        String[] data = new String[sizeOfMass];
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (int i = 0; i < sizeOfMass; i++) {
            int question = Util.random();
            data[i] = String.valueOf(question);
            data[++i] = getTrueAnswer(question);
        }
        Engine.game(rule, data);
    }

    private static boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    private static String getTrueAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }
}
