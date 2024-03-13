package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Progression {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 10;

    public static void startGame() throws IOException {
        final int countNumbersInProgression = 10;
        String rule = "What number is missing in the progression?";
        ArrayList<HashMap<String, String>> data = new ArrayList<>(COUNT_OF_ROUNDS);
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            int stepProgression = Util.random(START_RANGE, END_RANGE);
            int startProgression = Util.random(START_RANGE, END_RANGE);
            data.add(generateProgression(countNumbersInProgression, startProgression, stepProgression));
        }
        Engine.game(rule, data);
    }

    private static HashMap<String, String> generateProgression(int countNumbersInProgression,
                                                               int startProgression,
                                                               int stepProgression) {
        HashMap<String, String> result = new HashMap<>();
        int guessNumber = 0;
        int orderNumber = Util.random(START_RANGE, END_RANGE);
        int currNumber = startProgression;
        StringBuilder question = new StringBuilder();
        for (int j = 0; j < countNumbersInProgression; j++) {
            if (j != orderNumber) {
                question.append(currNumber).append(" ");
            } else {
                question.append(".. ");
                guessNumber = currNumber;
            }
            currNumber += stepProgression;
        }
        result.put("Question", String.valueOf(question).trim());
        result.put("Answer", String.valueOf(guessNumber));
        return result;
    }
}
