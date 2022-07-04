package thread.threadtest2;

public class ThreadTask {
	public ThreadTask() {;}
	
	public void printFirst(Runnable first) {
		first.run(); //수정 금지
	}
	public void printSecond(Runnable second) {
		second.run(); //수정 금지
	}
	public void printThird(Runnable third) {
		third.run(); //수정 금지
	}
}
