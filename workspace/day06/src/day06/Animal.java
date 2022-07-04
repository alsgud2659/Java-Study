package day06;

import java.util.Random;

public class Animal {
	String name;
	int age;
	String feed;
	int feedCount;
	int life;
	
	public Animal(String name, int age, String feed, int feedCount, int life) {
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}

	boolean eat() {
		if(feedCount != 0) {
			feedCount--;
			life++;
			return true;
		}
		return false;
	}
	
	void sleep() {
		life++;
	}
	
	Quiz walk(Quiz[] quiz) {
		life--;

		int[] arData = new int[10];
		int rating = 10;
		Random r = new Random();
		
		for (int i = 0; i < rating / 10; i++) {
			arData[i] = 1;
		}
		
		if(arData[r.nextInt(10)] == 1) {
			//잭팟 문제
			for (int i = 0; i < quiz.length; i++) {
				if(quiz[i].jackpot) {
					return quiz[i];
				}
			}
		}
		
		//일반 문제
		Quiz q = null;
		while(true) {
			q = quiz[r.nextInt(quiz.length)];
			if(!q.jackpot) { break; }
		}
		return q;
	}
}









