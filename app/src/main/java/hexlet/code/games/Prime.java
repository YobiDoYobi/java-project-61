package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Prime {
    public static void startGame() throws IOException {
        ArrayList<HashMap<String, String>> data = new ArrayList<>(COUNT_OF_ROUNDS);
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            HashMap<String, String> round = new HashMap<>();
            int question = Util.random();
            round.put("Question", String.valueOf(question));
            round.put("Answer", isPrime(question) ? "yes" : "no");
            data.add(round);
        }
        Engine.game(rule, data);
    }

    private static boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }
}
