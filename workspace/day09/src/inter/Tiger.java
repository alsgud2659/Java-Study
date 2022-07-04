package inter;

//강제성을 없애 주기 위한 Adapter를 선언하여 오류를 해결한다.
public class Tiger extends PetAdapter {

	@Override
	public void poop() {
		System.out.println("알아서 잘 쌉니다.");
	}

}
