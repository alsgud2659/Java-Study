package day02;

public class FormatTest {
	public static void main(String[] args) {
		String name = "한동석";
		int age = 20;
		double weight = 81.54;
		
		System.out.printf("이름 : %s\n", name);
		//서식문자를 사용해서 나이와 몸무게를 출력!
		System.out.printf("나이 : %d살\n", age);
//		%f에서 소수점을 자르면 반올림된다.
		System.out.printf("몸무게 : %.1fkg\n", weight);
	}
}
