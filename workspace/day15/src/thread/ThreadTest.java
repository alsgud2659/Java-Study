package thread;

public class ThreadTest {
	public static void main(String[] args) {
		//Runnable을 지정받은 후 run()를 재정의한다.
		Thread2 t1 = new Thread2();
		Runnable t2 = new Thread2();
		
		//start()는 Thread 클래스에 선언되어 있기 때문에
		//Thread객체를 생성한 후 생성자에 run()이 재정의된 객체를 전달한다.
		//이 때 각 Thread의 이름도 문자열로 전달할 수 있다.
		Thread thread1 = new Thread(t1, "?");
		Thread thread2 = new Thread(t2, "!");
		
		thread1.start();
		thread2.start();
		
		//Thread를 상속받은 후 run()를 재정의한다.
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
//		
		//run()을 바로 사용하면 단일 쓰레드로 인식한다.
////		t1.run();
////		t2.run();
//		
//		Thread 클래스에 있는 start()메소드를 사용하여 해당 객체에 재정의 된 run메소드를 스케줄링해준다.
//		t1.start();
//		t2.start();
//
//		//join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("메인 쓰레드 종료");
	}
}
