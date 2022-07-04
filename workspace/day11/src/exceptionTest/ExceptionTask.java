package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
		
		//5개의 정수만 입력받기
		//- 무한 입력 가능
		//- q를 입력하면 나가기
		//- 5개의 정수는 배열에 담기
		//- if문은 딱 한 번만 사용하기
		Scanner sc = new Scanner(System.in);
		String msg = "번째 정수 입력[q: 나가기]";
		String temp = null;
		int[] arData = new int[5];
		int idx = 0;
		
		while(true) {
			System.out.println(++idx + msg);
			temp = sc.next();
			//toLowerCase()는 String 클래스에 선언된 메소드이다.
			//대문자를 모두 소문자로 바꿔주는 기능을 한다.
			if(temp.toLowerCase().equals("q")) { break; }
			try {
				arData[idx - 1] = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				System.out.println("입력하기 전에 생각이란 걸 해봤나요?");
				idx --;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("아 진짜.. 5개만 입력하라니까요?");
				for (int i = 0; i < arData.length; i++) {
					System.out.print(arData[i] + " ");
				}
				break;
			}
		}
	}
}











