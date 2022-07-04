package abstractTest;

public class Refrigerator extends Electronics {

	@Override
	void on() {
		System.out.println("버튼을 on쪽으로 누른다.");
	}

	@Override
	void off() {
		System.out.println("버튼을 off쪽으로 누른다.");
	}

}
