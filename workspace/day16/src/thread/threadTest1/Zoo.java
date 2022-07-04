package thread.threadTest1;

public class Zoo {
	public static void main(String[] args) {
		String[] sounds = {"어흥", "우끼끼", "아아아아악!!!"};
		Animal[] animals = new Animal[sounds.length];
		Thread[] threads = new Thread[sounds.length];
		
		for (int i = 0; i < animals.length; i++) {
			animals[i] = new Animal();
			threads[i] = new Thread(animals[i], sounds[i]);
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			if(i != 0) {
				try {threads[i].join();} catch (InterruptedException e) {;}
			}
		}
	}
}
