package anonymous;

public abstract class FormAdapter implements Form{

	//메뉴제작은 반드시 해야하기 때문에 구현하지 않고 강제성을 유지한다.
	//판매 방식은 골라서 재정의해야 하기 때문에 구현해 놓는다.
	@Override
	public void sell(String order) {}
	
}
