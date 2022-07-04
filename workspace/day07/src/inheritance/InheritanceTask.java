package inheritance;
//자동차 클래스
// 브랜드, 색상, 가격
//- 열쇠로 시동 킴
//- 열쇠로 시동 끔
class Car{
	String brand;
	String color;
	int price;
	
	public Car() {}
	
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
	void engineStop() {
		System.out.println("열쇠로 시동 끔");
	}
}

//슈퍼카 클래스
// 브랜드, 색상, 가격, 모드(String)
//- 열쇠로 시동 킴, 음성으로 시동 킴
//- 음성으로 시동 끔
//- 지붕 열림
//- 지붕 닫힘
class SuperCar extends Car{
	String mode;
	
	public SuperCar() {}
	
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}

	@Override
	void engineStart() {
		super.engineStart();
		System.out.println("음성으로 시동 킴");
	}
	
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}
	
	void openRoof() {
		System.out.println("뚜껑 열림");
	}
	
	void closeRoof() {
		System.out.println("뚜껑 닫힘");
	}
}


public class InheritanceTask {
	public static void main(String[] args) {
		SuperCar ferrari = new SuperCar("Ferrari", "Red", 35_000, "Sport");
		ferrari.engineStart();
		ferrari.engineStop();
	}
}









