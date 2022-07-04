package day04;

public class MethodTest {
	
	//f(x) = 2x+1
	//단 x는 실수이다.
	
	double f(double x){
		double result = 2*x + 1;
		return result;
	}
	
	//프로그램을 만들어주는 역할
	//static 키워드를 붙이면 컴파일러가 가장 먼저 메모리에 할당해준다.
	public static void main(String[] args) {
		MethodTest m = new MethodTest();
		double result = m.f(10.5) + 9;
		System.out.println(result);
	}
}












