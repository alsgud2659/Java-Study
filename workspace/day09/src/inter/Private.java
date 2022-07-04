package inter;

public class Private implements Soldier {

	@Override
	public void saulte() {
		System.out.println("충!!!!!!!!!!!!!!!!!!!!!!!!!!성!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void work() {
		System.out.println("열심히 뛰어다니지만 결과가 좋지 않다. 그러다 어디 간다.");
	}

	@Override
	public void eat() {
		System.out.println("허리를 곧게 펴고 직각식사를 한다.");
	}

	@Override
	public void sleep() {
		System.out.println("고향 생각에 눈물로 밤을 지새운다. 그러다 어디 간다.");
	}
}
