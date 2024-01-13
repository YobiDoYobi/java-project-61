package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int EXIT = 0;
    private static final int CLI = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;

    public static void main(String[] args) throws IOException {
        int game = getGame();
        runGame(game);
    }

    private static void runGame(int game) throws IOException {
        switch (game) {
            case EXIT -> System.out.println("Bye!");
            case CLI -> hexlet.code.games.Cli.startGame();
            case EVEN -> hexlet.code.games.Even.startGame();
            case CALC -> hexlet.code.games.Calc.startGame();
            case GCD -> hexlet.code.games.GCD.startGame();
            case PROGRESSION -> hexlet.code.games.Progression.startGame();
            case PRIME -> hexlet.code.games.Prime.startGame();
            default -> {
                System.out.println("There is no variant '" + game + "'");
                checkGame(game);
            }
        }
    }

    private static void checkGame(int game) throws IOException {
        if (game < EXIT || game > PRIME) {
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
