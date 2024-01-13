package hexlet.code.games;

import java.io.IOException;
import java.util.stream.IntStream;

import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.start;
import static hexlet.code.Engine.getAnswerString;
import static hexlet.code.Engine.checkAnswer;
import static hexlet.code.Engine.random;
import static hexlet.code.Engine.COUNT_OF_ROUNDS;
import static hexlet.code.Engine.isGameWin;
import static hexlet.code.Engine.end;

public class Prime {
    public static void startGame() throws IOException {
        start("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        for (int i = 0; i < COUNT_OF_ROUNDS & isGameWin(); i++) {
            int number = random();
            askQuestion(number);
            checkAnswer(getAnswerString(), getTrueAnswer(number));
        }
        end();
    }

    private static boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    private static String getTrueAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }
}
