package day03;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
		String msg = "Q.당신이 좋아하는 색을 선택하세요.";
		String choiceMsg = "1.빨간색\n2.노란색\n3.검은색\n4.흰색";
		
		String redMsg = "불같고 열정적이고 적극적이다.";
		String yellowMsg = "발랄하고 밝고 귀엽고 개성있고 유하다.";
		String blackMsg = "묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다.";
		String whiteMsg = "천사같고 깔끔하고 정리를 좋아고 배려심이 많다.";
		String errorMsg = "다시 시도해주세요";
		String resultMsg = null;
		
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg + "\n" + choiceMsg);
		choice = sc.nextInt();
		
		if(choice == 1) {
			resultMsg = redMsg;
		}else if(choice == 2) {
			resultMsg = yellowMsg;
		}else if(choice == 3) {
			resultMsg = blackMsg;
		}else if(choice == 4) {
			resultMsg = whiteMsg;
		}else {
			resultMsg = errorMsg;
		}
		
		System.out.println(resultMsg);
	
	}
}











