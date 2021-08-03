package modelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Game;

public class GameTest {

	@Test
	public void addPlayers() {
		Game game = new Game();
		assertTrue(game.enterPlayers("3"));
		assertNotNull(game.getPlayers());
		assertEquals(3, game.getPlayers().size());
		
		assertFalse(game.enterPlayers("7"));
		assertFalse(game.enterPlayers("asdf"));
		assertFalse(game.enterPlayers(""));
	}
	
	@Test
	public void printScoreboard() {
		
	}
	
	@Test
	public void enterPlayers() {
		Game game = new Game();
		boolean validInput = game.enterPlayers("2");
		assertTrue(validInput);
		assertNotNull(game.getPlayers());
		assertEquals(2, game.getPlayers().size());
	
		
		game = new Game();
		validInput = game.enterPlayers("7");
		assertFalse(validInput);
		assertNull(game.getPlayers());
		
		
		game = new Game();
		validInput = game.enterPlayers("nan");
		assertFalse(validInput);
		assertNull(game.getPlayers());
		
		
		game = new Game();
		validInput = game.enterPlayers("0");
		assertFalse(validInput);
		assertNull(game.getPlayers());
		
	}

}
