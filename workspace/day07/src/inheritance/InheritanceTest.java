package inheritance;

class A{
	String nameA = "A";
	int data = 10;
	
	public A() {
		System.out.println("부모 생성자 호출");
	}
}

class B extends A{
	String nameB = "B";
	
	public B() {
		System.out.println("자식 생성자 호출");
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.nameA);
		b.printData();
	}
}
