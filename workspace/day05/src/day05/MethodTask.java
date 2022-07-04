package day05;

import java.util.Arrays;

public class MethodTask {
	
	// 아이언
	// 1~10까지 println()으로 출력하는 메소드
	void printFrom1To10(){
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}
	
	// "홍길동"을 n번 println()으로 출력하는 메소드
	void printHong(int time){
		for (int i = 0; i < time; i++) {
			System.out.println("홍길동");
		}
	}
	
	// 브론즈
	// 이름을 n번 println()으로 출력하는 메소드
	void printName(String name, int time){
		for (int i = 0; i < time; i++) {
			System.out.println(name);
		}
	}
	
	// 세 정수의 뺄셈을 해주는 메소드
	int sub(int num1, int num2, int num3){
		return num1 - num2 - num3;
	}
	
	// 실버
	// 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
	int[] div(int num1, int num2){
		int[] result = null;
		if(num2 != 0) {
			result = new int[2];
			result[0] = num1 / num2;
			result[1] = num1 % num2;
		}
		return result;
	}
	// 1~n까지의 합을 구해주는 메소드
	int getTotalFrom1(int end){
		int total = 0;
		for (int i = 0; i < end; i++) {
			total += i + 1;
		}
		return total;
	}
	
	// 골드
	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int change(int num){
		return ++num;
	}
	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String changeToUpperAndLower(String str){
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 65 && c <= 90) {//대문자
				result += (char)(c + 32);
			}else if(c >= 97 && c <= 122) {//소문자
				result += (char)(c - 32);
			}else {//그 이외의 문자
				result += c;
			}
		}
		
		return result;
		
	}
	
	// 플래티넘
	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int getCount(String str, char c){
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
	
	// 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	int getValue(int[] arData, int ordinal){
		return arData[ordinal - 1];
	}
	
	// 다이아
	// 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int changeToInteger(String hangle){
		String hangleOri = "공일이삼사오육칠팔구";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += hangleOri.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}
	
	// 마스터
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)
	void getMaxAndMin(int[] arData, int[] results) {
		results[0] = arData[0];
		results[1] = arData[0];
		
		for (int i = 1; i < arData.length; i++) {
			if(results[0] < arData[i]) { results[0] = arData[i]; }
			if(results[1] > arData[i]) { results[1] = arData[i]; }
		}
	}
	
	public static void main(String[] args) {
		
		//정수에서 쉼표 대신 _를 사용한다.
		//1,000,000
//		int data = 1_000_000;
//		System.out.println(data);
		
//		MethodTask m = new MethodTask();
		
//		 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)
//		int[] results = new int[2];
//		int[] arData = {1, 3, 6, 4, 2};
//		
//		m.getMaxAndMin(arData, results);
//		
//		System.out.println("최대값 : " + results[0]);
//		System.out.println("최소값 : " + results[1]);
		
//		 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
//		int result = m.changeToInteger("공일삼구육삼칠팔사");
//		System.out.println(result);
		
//		 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
//		int[] arData = {1, 34, 64, 65, 12};
//		System.out.println(m.getValue(arData, 3));
		
//		 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//		int count = m.getCount("ABCAAAA", 'A');
//		System.out.println(count);
		
//		 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//		String result = m.changeToUpperAndLower("Apple1234!@#$");
//		System.out.println(result);
		
//		 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//		int result = m.change(4);
//		String msg = result % 2 == 0 ? "홀수에서 짝수로 바뀌었습니다." : "짝수에서 홀수로 바뀌었습니다.";
//		System.out.println(msg);
		
//		 1~n까지의 합을 구해주는 메소드
//		int result = m.getTotalFrom1(10);
//		System.out.println(result);
		
//		 세 정수의 뺄셈을 해주는 메소드
//		int result = m.sub(1, 2, 3);
//		System.out.println(result);
		
//		 이름을 n번 println()으로 출력하는 메소드
//		m.printName("한동석", 5);
		
//		 "홍길동"을 n번 println()으로 출력하는 메소드
//		m.printHong(10);
		
//		 1~10까지 println()으로 출력하는 메소드
//		m.printFrom1To10();
		
//		 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
//		int[] result = m.div(10, 3);
//		
//		if(result == null) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}else {
//			System.out.println("몫 : " + result[0]);
//			System.out.println("나머지 : " + result[1]);
//		}
	}
}










