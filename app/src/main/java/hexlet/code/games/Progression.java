package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;


public class Progression {
    public static void startGame() throws IOException {
        final int startRange = 0;
        final int endRange = 10;
        final int countNumbersInProgression = 10;
        String rule = "What number is missing in the progression?";
        int sizeOfMass = COUNT_OF_ROUNDS * 2;
        String[] data = new String[sizeOfMass];
        for (int i = 0; i < sizeOfMass; i++) {
            int startProgression = Util.random(startRange, endRange);
            int stepProgression = Util.random(startRange, endRange);
            int guessNumber = 0;
            int orderNumber = Util.random(startRange, endRange);
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
            data[i] = String.valueOf(question).trim();
            data[++i] = String.valueOf(guessNumber);
        }
        Engine.game(rule, data);
    }
}
