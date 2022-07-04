package inter;

public class Pfc implements Soldier {

	@Override
	public void saulte() {
		System.out.println("충!성!");
	}

	@Override
	public void work() {
		System.out.println("일을 잘한다.");
	}

	@Override
	public void eat() {
		System.out.println("선임의 식판과 후임의 식판을 번갈아보며 식사한다. 그리고 어디 간다.");
	}

	@Override
	public void sleep() {
		System.out.println("코를 골며 잔다. 그러다 어디 간다.");
	}

}
