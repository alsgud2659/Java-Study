package thread.threadtest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//사용자가 입력한 정수를 담을 배열
		int[] arInput = new int[3];
		//Thread1, Thread2, Thread3
		Thread[] arThread = new Thread[3];
		//run()이 구현된 객체
		ThreadTask tt = new ThreadTask();
		
		for (int i = 0; i < arThread.length; i++) {
			//tt를 전달하여 스케줄링 준비를 한다.
			arThread[i] = new Thread(tt);
		}
		
		System.out.print("입력 : ");
		for (int i = 0; i < arInput.length; i++) {
			arInput[i] = sc.nextInt();
			//각 쓰레드의 이름은 사용자가 입력한 정수로 설정한다.
			arThread[i].setName(arInput[i] + "");
		}
		
		for (int i = 0; i < arThread.length; i++) {
			//하나씩 순서대로 실행되어야 하니까 join()을 매번 사용해준다.
			arThread[i].start();
			try {arThread[i].join();} catch (InterruptedException e) {;}
		}
		
	}
}






