package day02;

import java.util.Scanner;

public class InputTask2 {
	public static void main(String[] args) {
		//3개의 정수를 한 번에 입력받은 후
		//3개의 정수의 합 출력
		String msg = "세 정수를 입력하세요.\n예)1 3 4";
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, result = 0;
		
		System.out.println(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
//		num1 = Integer.parseInt(sc.next());
//		num2 = Integer.parseInt(sc.next());
//		num3 = Integer.parseInt(sc.next());
		result = num1 + num2 + num3;
		
		System.out.printf("%d + %d + %d = %d", num1, num2, num3, result);
	}
}
