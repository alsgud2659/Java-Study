package day03;

import java.util.Scanner;

public class Oper4 {
	public static void main(String[] args) {
		//사용자에게 키를 입력받고, 정수라면 정수로 출력,
		//실수라면 실수로 출력.
		//※ 삼항연산자 사용!
		
		//183 --> 183출력
		//183.5 --> 183.5출력
		double height = 0.0;
		boolean check = false; 
		char newLine = '\n';
		String format = null;
		String msg = "키 : ";
		Scanner sc = new Scanner(System.in);
		
		System.out.print(msg);
		height = sc.nextDouble();
		
		check = height - (int)height == 0;
		
//		System.out.println(check ? (int)height : height);
		
		format = check ? "%.0fcm%c" : "%.2fcm%c";
		System.out.printf(format, height, newLine);
	}
}










