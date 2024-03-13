package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static hexlet.code.Engine.COUNT_OF_ROUNDS;

public class Calc {

    public static void startGame() throws IOException {
        ArrayList<HashMap<String, String>> data = new ArrayList<>(COUNT_OF_ROUNDS);
        String rule = "What is the result of the expression?";
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            HashMap<String, String> round = new HashMap<>();
            //генерируются числа
            int number1 = Util.random();
            int number2 = Util.random();
            //генерируется оператор
            String operations = "+-*";
            Random random = new Random();
            int length = operations.length();
            int randIndex = random.nextInt(length);
            char operation = operations.charAt(randIndex);

            round.put("Question", number1 + " " + String.valueOf(operation) + " " + number2);
            round.put("Answer", getTrueAnswer(number1, number2, operation));
            data.add(round);
        }
        Engine.game(rule, data);
    }

    private static String getTrueAnswer(int number1, int number2, char operation) {
        int question = switch (operation) {
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '+' -> number1 + number2;
            default -> 0;
        };
        return String.valueOf(question);
    }
}
