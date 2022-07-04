package day04;

public class MethodTask {
	
	// 아이언
	// 1~10까지 println()으로 출력하는 메소드
	// "홍길동"을 n번 println()으로 출력하는 메소드
	
	// 브론즈
	// 이름을 n번 println()으로 출력하는 메소드
	// 세 정수의 뺄셈을 해주는 메소드
	
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
	
	// 골드
	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	
	// 플래티넘
	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	// 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	
	// 다이아
	// 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	
	// 마스터
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드(메소드 안에서 출력 금지, 리턴타입은 void)

	public static void main(String[] args) {
		
	}
}
