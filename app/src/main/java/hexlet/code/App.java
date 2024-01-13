package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int game = getGame();
        runGame(game);
    }

    private static void runGame(int game) throws IOException {
        switch (game) {
            case 0 -> System.out.println("Bye!");
            case 1 -> hexlet.code.games.Cli.startGame();
            case 2 -> hexlet.code.games.Even.startGame();
            case 3 -> hexlet.code.games.Calc.startGame();
            case 4 -> hexlet.code.games.GCD.startGame();
            case 5 -> hexlet.code.games.Progression.startGame();
            case 6 -> hexlet.code.games.Prime.startGame();
            default -> {
                System.out.println("There is no variant '" + game + "'");
                checkGame(game);
            }
        }
    }

    private static void checkGame(int game) throws IOException {
        if (game < 0 || game > 6) {
            game = getGame();
            runGame(game);
        }
    }

    private static int getGame() throws IOException {
        showMenu();
        int game = -1;
        String choice = getChoiceString();
        try {
            game = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.print("You entered not numeric value: " + choice + "! Please enter correct value!\n");
        }
        return game;
    }

    private static String getChoiceString() throws IOException {
        String choice = reader.readLine();
        while (choice.isEmpty()) {
            System.out.print("Please choose game or exit: ");
            choice = reader.readLine();
        }
        return choice;
    }

    private static void showMenu() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
    }
}
