package day06;

public class Quiz {
	String exercise;
	int answer;
	int feedCount;
	boolean jackpot;
	
	//Alt + Shift + s, o : 생성자 생성
	public Quiz(String exercise, int answer, int feedCount) {
		this.exercise = exercise;
		this.answer = answer;
		this.feedCount = feedCount;
	}

	public Quiz(String exercise, int answer, int feedCount, boolean jackpot) {
		this.exercise = exercise;
		this.answer = answer;
		this.feedCount = feedCount;
		this.jackpot = jackpot;
	}
}
