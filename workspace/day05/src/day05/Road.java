package day05;

class Car{
	//전역 변수
	//인스턴스 변수
	String brand;
	String color;
	int price;
	
	public Car(/*매개 변수*/String brand, String color, int price){
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public Car(int price){
		this.price = price;
	}
	
	public Car(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	void engineStart() {
		//지역 변수
//		int data = 10;
//		System.out.println(this);
		System.out.println(this.brand + "시동 켜기");
	}
	
	void engineStop() {
		System.out.println(brand + "시동 끄기");
	}
}

public class Road {
	public static void main(String[] args) {
		Car momCar = new Car("Benz", "Black", 10_000);
		Car dadyCar = new Car("BMW", "Blue", 8_000);
		Car myCar = new Car(600);
		
		momCar.engineStart();
		dadyCar.engineStart();
		
//		System.out.println(momCar);
//		System.out.println(dadyCar);
//		System.out.println(myCar);
		
	}
}










