package models;

public class Frame {

	private int firstThrow;
	
	private int secondThrow;
	
	private int thirdThrow;
	
	private int frameScore;
	
	
	public Frame(int firstThrow, int secondThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		calculateScore();
	}
	
	public Frame(Frame newFrame, int thirdThrow) {
		this.firstThrow = newFrame.getFirstThrow();
		this.secondThrow = newFrame.getSecondThrow();
		this.thirdThrow = thirdThrow;
		this.frameScore = calculateScoreOfLastFrame();
	}
	
	public int calculateScore() {
		frameScore = firstThrow + secondThrow;
		return frameScore;
	}
	
	public int calculateScoreOfLastFrame() {
		frameScore = firstThrow + secondThrow + thirdThrow;
		return frameScore;
	}
	
	public boolean isStrike() {
		return firstThrow == 10;
	}
	
	public boolean isSpare() {
		return firstThrow != 10 && (firstThrow + secondThrow == 10);
	}
	
	public void addBonusPoints(final int bonusPoints) {
		frameScore += bonusPoints;
	}
	
	public int getFrameScore() {
		return frameScore;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public int getThirdThrow() {
		return thirdThrow;
	}
	
	
}
