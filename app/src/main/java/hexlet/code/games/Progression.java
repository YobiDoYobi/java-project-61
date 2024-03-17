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
            HashMap<String, String> round = new HashMap<>();
            int stepProgression = Util.random(START_RANGE, END_RANGE);
            int startProgression = Util.random(START_RANGE, END_RANGE);
            int orderNumber = Util.random(START_RANGE, END_RANGE);
            String guessNumber = null;
            StringBuilder question = new StringBuilder();
            String[] progression = generateProgression(countNumbersInProgression, startProgression, stepProgression);
            for (int j = 0; j < progression.length; j++) {
                if (j != orderNumber) {
                    question.append(progression[j]).append(" ");
                } else {
                    question.append(".. ");
                    guessNumber = progression[j];
                }
            }
            round.put("Question", String.valueOf(question).trim());
            round.put("Answer", String.valueOf(guessNumber));
            data.add(round);
        }
        Engine.game(rule, data);
    }

    private static String[] generateProgression(int countNumbersInProgression,
                                                int startProgression,
                                                int stepProgression) {
        String[] progression = new String[countNumbersInProgression];
        progression[0] = String.valueOf(startProgression);
        for (int j = 1; j < countNumbersInProgression; j++) {
            progression[j] = String.valueOf(Integer.parseInt(progression[j - 1]) + stepProgression);
        }
        return progression;
    }
}
