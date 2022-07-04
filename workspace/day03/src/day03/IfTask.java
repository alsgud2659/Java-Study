package day03;

import java.util.Scanner;

public class IfTask {
	public static void main(String[] args) {
		//두 정수를 입력받고 대소비교 하기
		//※ if문 사용
		int num1 = 0, num2 = 0;
		Scanner sc = new Scanner(System.in);
		String n1Msg = "첫 번째 정수 : ";
		String n2Msg = "두 번째 정수 : ";
		String resultMsg = null;
		
		System.out.println(n1Msg);
		num1 = sc.nextInt();
		System.out.println(n2Msg);
		num2 = sc.nextInt();
		
		if(num1 > num2) {
			resultMsg = "큰 값 : " + num1;
		}else if(num1 != num2) {
			resultMsg = "큰 값 : " + num2;
		}else {
			resultMsg = "두 수는 같습니다.";
		}
		
		System.out.println(resultMsg);
		
	}
}








