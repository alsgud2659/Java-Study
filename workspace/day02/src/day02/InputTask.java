package day02;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
		//두 정수를 입력한 후 덧셈 결과 출력
		//단, next()만 사용
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		String n1Msg = "첫번째 정수 : ";
		String n2Msg = "두번째 정수 : ";
		
		System.out.print(n1Msg);
		num1 = Integer.parseInt(sc.next());
		
		System.out.print(n2Msg);
		num2 = Integer.parseInt(sc.next());
		
		System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
	}
}











