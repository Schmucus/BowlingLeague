package modelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Frame;

public class FrameTest {

	@Test
	public void calculateScore() {
		Frame frame = new Frame(3, 4);
		assertEquals(7, frame.getFrameScore());
		
		Frame lastFrame = new Frame(frame, 6);
		assertEquals(13, lastFrame.getFrameScore());
		
	}

	
	@Test
	public void isStrike() {
		Frame frame = new Frame(3, 4);
		assertFalse(frame.isStrike());
		
		frame = new Frame(0, 10);
		assertFalse(frame.isStrike());
		
		frame = new Frame(0, 0);
		assertFalse(frame.isStrike());
		
		frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void isSpare() {
		Frame frame = new Frame(3, 4);
		assertFalse(frame.isSpare());
		
		frame = new Frame(10, 0);
		assertFalse(frame.isSpare());
		
		frame = new Frame(0, 0);
		assertFalse(frame.isSpare());
		
		frame = new Frame(8, 2);
		assertTrue(frame.isSpare());
		
		frame = new Frame(0, 10);
		assertTrue(frame.isSpare());
	}
	
	@Test
	public void addBonusPoints() {
		Frame frame = new Frame(3,4);
		frame.addBonusPoints(7);
		assertEquals(14, frame.getFrameScore());
	}
}
