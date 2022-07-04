package thread;

public class Thread1 extends Thread{
	
	String data;
	
	public Thread1() {;}

	public Thread1(String data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {sleep(500);} catch (InterruptedException e) {;}
		}
	}
	
}
