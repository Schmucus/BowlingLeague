package modelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import models.Frame;
import models.Player;

public class PlayerTest {

	@Test
	public void testConstructor() {
		Player player = new Player("Peter");
		assertEquals("Peter", player.getName());
	}

	@Test
	public void testCommonOperations() {
		Player player = new Player("P1");
		Frame frame = new Frame(3, 3);
		player.addFrame(0, frame);
		frame = new Frame(4, 3);
		player.addFrame(1, frame);
		frame = new Frame(2, 6);
		player.addFrame(2, frame);

		List<Frame> frames = player.getFrames();
		assertNotNull(frames);
		assertEquals(3, frames.size());
		assertEquals(21, player.getTotalScore());

		
		// test calculating points for strikes
		player = new Player("P2");
		for (int i = 0; i < 9; i++) {
			player.addFrame(i, new Frame(10, 0));
		}
		player.addFrame(9, new Frame(new Frame(10, 10), 10));

		assertNotNull(player.getFrames());
		assertEquals(10, player.getFrames().size());
		assertEquals(300, player.getTotalScore());

		
		// test calculating points for a spare
		player = new Player("P1");
		frame = new Frame(3, 7);
		player.addFrame(0, frame);
		frame = new Frame(4, 3);
		player.addFrame(1, frame);

		assertEquals(14, player.getFrames().get(0).getFrameScore());
		assertEquals(7, player.getFrames().get(1).getFrameScore());

		
		// test calculating points with spare in last round
		player = new Player("P3");
		for (int i = 0; i < 9; i++) {
			player.addFrame(i, new Frame(3, 3));
		}
		player.addFrame(9, new Frame(new Frame(6, 4), 4));
		assertEquals(68, player.getTotalScore());

		
		// test calculating points with strike in last round
		player = new Player("P4");
		for (int i = 0; i < 9; i++) {
			player.addFrame(i, new Frame(3, 3));
		}
		player.addFrame(9, new Frame(new Frame(10, 4), 2));
		assertEquals(70, player.getTotalScore());

		
		// test calculating points with no pins hit in any round
		player = new Player("P4");
		for (int i = 0; i < 9; i++) {
			player.addFrame(i, new Frame(0, 0));
		}
		player.addFrame(9, new Frame(new Frame(0, 0), 0));
		assertEquals(0, player.getTotalScore());
	}

}
