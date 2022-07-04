package inter;

public class Corperal implements Soldier {

	@Override
	public void saulte() {
		System.out.println("ㅊㅅ");
	}

	@Override
	public void work() {
		System.out.println("후임을 시킨다. 그러다 어디로 데리고 간다.");
	}

	@Override
	public void eat() {
		System.out.println("경치를 보며 식사한다.");
	}

	@Override
	public void sleep() {
		System.out.println("계속 잔다.");
	}

}
