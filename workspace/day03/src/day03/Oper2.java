package day03;

import java.util.Scanner;

public class Oper2 {
	public static void main(String[] args) {
		//두 정수 입력받고 대소비교
		int num1 = 0, num2 = 0;
		String result = null;
		String n1Msg = "첫번째 정수 : ", n2Msg = "두번째 정수 : ";
		Scanner sc = new Scanner(System.in);
		
		System.out.println(n1Msg);
		num1 = sc.nextInt();
		System.out.println(n2Msg);
		num2 = sc.nextInt();
		
		result = num1 > num2 ? "큰 값 : " + num1 : num1 == num2 ? "두 수가 같습니다." : "큰 값 : " + num2;
		System.out.println(result);
	}
}
