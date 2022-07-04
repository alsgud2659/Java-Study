package abstractTest;

public class WashingMachine extends Electronics{

	@Override
	void on() {
		System.out.println("전원 버튼을 누른다.");
	}

	@Override
	void off() {
		on();
	}
}
