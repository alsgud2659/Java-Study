package day03;

public class Oper1 {
	public static void main(String[] args) {
		boolean isTrue = 10 > 9;
		System.out.println(10 == 11);
		System.out.println(10 != 11);
		System.out.println(isTrue);
		System.out.println(isTrue && 10 == 11);
		System.out.println(isTrue || 10 == 11);
		System.out.println(isTrue && !(10 == 11));
	}
}
