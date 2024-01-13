package hexlet.code.games;

import java.io.IOException;

import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.start;
import static hexlet.code.Engine.getAnswer;
import static hexlet.code.Engine.checkAnswer;
import static hexlet.code.Engine.random;
import static hexlet.code.Engine.COUNT_OF_ROUNDS;
import static hexlet.code.Engine.isGameWin;
import static hexlet.code.Engine.end;


public class Even {
    public static void startGame() throws IOException {
        int startRange = 0;
        int endRange = 100;
        start("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < COUNT_OF_ROUNDS & isGameWin(); i++) {
            int number = random(startRange, endRange);
            askQuestion(number);
            checkAnswer(getAnswer(), getTrueAnswer(number));
        }
        end();
    }

    private static String getTrueAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
