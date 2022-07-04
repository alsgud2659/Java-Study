package inter;

public class Puppy implements Pet{

	@Override
	public void sitDown() {
		System.out.println("앉습니다.");
	}

	@Override
	public void stop() {
		System.out.println("기다립니다.");
	}

	@Override
	public void poop() {
		System.out.println("아무데나 쌉니다.");
	}

	@Override
	public void 빵야() {
		System.out.println("총을 맞은 척 눕습니다.");
	}

}
