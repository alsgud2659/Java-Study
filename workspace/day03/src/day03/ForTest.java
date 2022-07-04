package day03;

public class ForTest {
	public static void main(String[] args) {
		//이름 10번 출력
//		for(int i = 0; i < 10; i = i+1) {
//			System.out.println(i + 1 + ".한동석");
//		}
		
		//이름 10번 출력, 10~1까지 출력
//		for (int i = 0; i < 10; i++) {
//			System.out.println(10 - i + ".한동석");
//		}
		//이름 10번 출력, 10~20까지 출력
		// - 10번 반복
//		int end = 10;
//		for (int i = 0; i < end; i++) {
//			System.out.println(i + 10 + (end == 11 ? "." : ".한동석"));
//			if(i == 9) {end++;}
//		}
		// - 11번 반복
		for (int i = 0; i < 11; i++) {
			System.out.println(i + 10 + (i == 10 ? "." : ".한동석"));
		}
	}
}









