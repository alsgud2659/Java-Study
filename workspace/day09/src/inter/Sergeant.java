package inter;

public class Sergeant extends SoldierAdapter {

	@Override
	public void eat() {
		System.out.println("군대 편의점으로 달려간다.");
	}

	@Override
	public void sleep() {
		System.out.println("24시간 잔다.");
	}
}
