package models;

import java.util.Scanner;

public class GameLogic {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String... args) {
		Game game = new Game();

		boolean correctInput = false;
		System.out.println("enter number of players:");
		while (!correctInput) {
			String input = scanner.nextLine();
			correctInput = game.enterPlayers(input);
			if (!correctInput) {
				System.out.println("Please enter a number between 1 and 6.");
			}
		}
		System.out.println(game.getPlayers().size() + " players added");

		for (int i = 0; i < 10; i++) {
			System.out.println("Round " + (i + 1) + " started");

			for (Player player : game.getPlayers()) {
				System.out.println(player.getName() + "'s turn.");
				
				int firstThrow = getThrowInput();
				int secondThrow = 0;
				int thirdThrow = 0;
				
				if (firstThrow != 10 || i == 9) {
					secondThrow = getThrowInput();
				}
				
				Frame currentFrame = new Frame(firstThrow, secondThrow);
				
				if (i == 9 && (currentFrame.isStrike() | currentFrame.isSpare())) {
					thirdThrow = getThrowInput();
					currentFrame = new Frame(currentFrame, thirdThrow);
				} else {
					currentFrame = new Frame(firstThrow, secondThrow);
				}

				player.addFrame(i, currentFrame);
				game.printScoreboard(player.getName());
			}
			
		}
		
		scanner.close();
		System.out.println("Game Over.");
	}
	

	private static int getThrowInput() {
		boolean correctInput = false;
		System.out.println("enter number of pins:");
		int numOfPins = 0;
		while (!correctInput) {
			String input = null;
			input = scanner.nextLine();
			try {
				numOfPins = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number between 0 and 10.");
			}
			correctInput = true;
		}
		return numOfPins;
	}

}
