package models;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Frame> frames = new ArrayList<>();
	
	private String name;
	
	
	public Player(final String name) {
		this.name = name;
	}
	
	public List<Frame> getFrames() {
		return frames;
	}


	public String getName() {
		return name;
	}
	
	public int getTotalScore() {
		int totalScore = 0;
		for (Frame frame : frames) {
			totalScore += frame.getFrameScore();
		}
		
		return totalScore;
	}
	
	public void addFrame(int currentRound, Frame currentFrame) {
		if (currentRound == 0) {
			frames.add(currentFrame);
		} else {
			Frame lastFrame = frames.get(currentRound - 1);
			Frame secondLastFrame = null;
			if (currentRound > 1) {
				secondLastFrame = frames.get(currentRound - 2);
			}
			if (lastFrame.isStrike()) {
				lastFrame.addBonusPoints(currentFrame.getFirstThrow() + currentFrame.getSecondThrow());
				if (secondLastFrame != null && secondLastFrame.isStrike()) {
					secondLastFrame.addBonusPoints(currentFrame.getFirstThrow());
				}
			} else {
				if (lastFrame.isSpare()) {
					lastFrame.addBonusPoints(currentFrame.getFirstThrow());
				}
			}
			frames.add(currentFrame);
		}
	}
	
	
	
	
}
