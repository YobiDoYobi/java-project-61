package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Even {
    public static void startGame() throws IOException {
        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        ArrayList<HashMap<String, String>> data = new ArrayList<>(COUNT_OF_ROUNDS);
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            int question = Util.random();
            HashMap<String, String> round = new HashMap<>();
            round.put("Question", String.valueOf(question));
            round.put("Answer", getTrueAnswer(question) ? "yes" : "no");
            data.add(round);
        }
        Engine.game(rule, data);
    }

    private static boolean getTrueAnswer(int number) {
        return number % 2 == 0;
    }
}
