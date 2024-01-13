package hexlet.code;

import hexlet.code.games.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		showMunu();
		String choice = getChoiceString();
		int game = -1;
		while (game == -1) {
			try {
				game = Integer.parseInt(choice);
				if (game < 0 || game > 6) {
					System.out.println("There is no variant '" + game + "'");
					showMunu();
					choice = getChoiceString();
					game = -1;
				}
			} catch (NumberFormatException e) {
				System.out.print("You entered not numeric value. Please enter correct value: ");
				choice = getChoiceString();
			}
		}

		switch (game) {
			case 1 -> Cli.startGame();
			case 2 -> Even.startGame();
			case 3 -> Calc.startGame();
			case 4 -> GCD.startGame();
			case 5 -> Progression.startGame();
			case 6 -> Prime.startGame();
		}
	}

	private static String getChoiceString() throws IOException {
		String choice = reader.readLine();
		while (choice.isEmpty()) {
			System.out.print("Please choose game or exit: ");
			choice = reader.readLine();
		}
		return choice;
	}

	private static void showMunu() {
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
