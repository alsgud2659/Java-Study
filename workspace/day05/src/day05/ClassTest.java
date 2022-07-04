package day05;

class A{
	int data = 100;
	
	A(){
		System.out.println("안녕");
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A();
//		System.out.println(a);
		a.data = 200;
		a.printData();
	}
}
