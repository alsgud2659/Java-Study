package day03;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
//		브론즈
//		1 ~ 100까지 출력
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i + 1);
//		}
//		100 ~ 1까지 출력
//		for (int i = 0; i < 100; i++) {
//			System.out.println(100 - i);
//		}
//		1 ~ 100까지 중 짝수만 출력
//		for(int i=0; i<50; i++) {
//			System.out.println((i + 1) * 2);
//		}
		
//		실버
//		1 ~ 10까지 합 출력
//		int total = 0;
//		for (int i = 0; i < 10; i++) {
////			total = total + i + 1;
//			total += i + 1;
//		}
//		System.out.println(total);
//		1 ~ n까지 합 출력
//		Scanner sc = new Scanner(System.in);
//		int end = 0, total = 0;
//		String msg = "1~n까지 합\nn : ";
//		System.out.print(msg);
//		end = sc.nextInt();
//		
//		for (int i = 0; i < end; i++) {
//			total += i + 1;
//		}
//
//		System.out.println(total);
		
//		골드
//		A ~ F까지 출력
//		for (int i = 0; i < 6; i++) {
//			System.out.println((char)(i + 65));
//		}
		
//		for(char i = 'A'; i < 'G'; i++) {
//			System.out.println(i);
//		}
		
//		A ~ F중 C제외하고 출력
//		i : 0 1 2 3 4
//		    A B C D E
//		for (int i = 0; i < 5; i++) {
//			System.out.println((char)(i + (i > 1 ? 66 : 65)));
//		}
		
//		다이아
//		0 1 2 3 0 1 2 3 0 1 2 3 출력
//		for (int i = 0; i < 12; i++) {
//			System.out.print(i % 4 + " ");
//		}
		
//		aBcDeFg....Z 출력
		for (int i = 0; i < 26; i++) {
			System.out.print((char)(i + (i % 2 == 0 ? 97 : 65)));
		}
	}
}








