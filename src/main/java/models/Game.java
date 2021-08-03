package models;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Player> players;

	public boolean enterPlayers(String input) {
		int numOfPlayers = 0;

		try {
			numOfPlayers = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		
		if (numOfPlayers < 1 || numOfPlayers > 6) {
			return false;
		}

		addPlayers(numOfPlayers);

		return true;
	}

	
	private void addPlayers(final int numOfPlayers) {
		if (players == null) {
			players = new ArrayList<>();
		}
		for (int i = 0; i < numOfPlayers; i++) {
			players.add(new Player(String.valueOf(i+1)));
		}
	}

	
	public List<Player> getPlayers() {
		return players;
	}
	
	
	public void printScoreboard(String name) {
		System.out.println("Scoreboard of " + name + ":");
		
		players.forEach(player -> {
			for (int i=0; i<player.getFrames().size(); i++) {
				Frame currentFrame = player.getFrames().get(i);
				if (currentFrame.isSpare() && i == player.getFrames().size() - 1) {
					System.out.println("??");
				} else {
					System.out.print(player.getFrames().get(i).getFrameScore() + "  ");
				}
			}
			System.out.print("    total: " + player.getTotalScore());
			System.out.println();
		});
	}

}
