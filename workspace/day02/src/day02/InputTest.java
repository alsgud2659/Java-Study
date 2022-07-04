package day02;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//초기값
		/*
		 * 정수	: 0
		 * 실수	: 0.0
		 * 문자	: ' '
		 * 문자열	: "", null
		 */
		String name = null;
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.println(name + "님 환영합니다.");
		
//		name = sc.next();
//		System.out.println(name + sc.next() + "님 환영합니다.");
	}
}












