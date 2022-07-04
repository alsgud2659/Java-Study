package sync;

public class ThreadTest implements Runnable{
	@Override
	public void run() {
		boolean check = false;
		while(true) {
			System.out.println("실행중...");
			
			if((check = Thread.interrupted())) {
				System.out.println(check);
				System.out.println("종료됨..."); 
				break;
			}
		}
	}
}
