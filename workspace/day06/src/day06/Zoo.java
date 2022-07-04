package day06;

import java.util.Scanner;

public class Zoo {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		animals[0] = new Animal("자라", 200, "시금치", 5, 5);
		animals[1] = new Animal("고양이", 15, "츄르", 1, 9);
		animals[2] = new Animal("개복치", 1, "플랑크톤", 9, 1);
		
		Quiz[] quiz = {
				new Quiz("Q. 크롱은 무슨 동물일까요?\n1.악어\n2.공룡\n3.사슴\n4.돌", 2, 2),
				new Quiz("Q. 착한 어린이는 누구일까요?♥\n1.부모님의 설거지를 도와드렸어요!\n2.부모님의 지갑을 숨겼어요!\n3.새벽까지 게임을 했어요!\n4.친구를 꼬집어봤어요!", 1, 2),
				new Quiz("Q. 철수와 영희 그리고 미진이가 피자를 시켰어요. 총 10조각 중에 철수가 3조각 먹고 영희가 1조각 먹다가 다시 놨어요. 미진이가 먹을 수 있는 피자 개수는?", 6, 100, true)
		};
		
		Scanner sc = new Scanner(System.in);
		
		String title = "★놀러와요!! 셀럽의 육지와 물!!★";
		String menuMsg = "안녕하세요! 캐릭터를 선택해봐요~!\n1.자라\n2.고양이\n3.개복치\n4.나가기";
		String actionMsg = "1. 먹기\n2.잠자기\n3.산책하기\n4.작별인사하기";
		int answer = 0;
		int charNum = 0;
		int actionChoice = 0;
		
		while(true) {
			System.out.println(menuMsg);
			charNum = sc.nextInt();
			if(charNum == 4) {break;}
			
			while(true) {
				System.out.println(actionMsg);
				actionChoice = sc.nextInt();
				if(actionChoice == 4) {break;}
				
				Animal animal = animals[charNum - 1];
				
				switch(actionChoice) {
				case 1://먹기
					if(animal.eat()) {
						System.out.println(animal.name + "이(가) " + animal.feed + "을(를) 냠냠 먹는 중!");
						System.out.println("현재 " + animal.feed + " 개수 : " + animal.feedCount);
						System.out.println("현재 체력 : " + animal.life);
						break;
					}
					System.out.println(animal.feed + "이(가) 없어요~! 얼른 산책하러 가요!");
					break;
				case 2://잠자기
					System.out.print("자는 중.");
					for (int i = 0; i < 3; i++) {
						System.out.print(".");
						try {Thread.sleep(1000);} catch (InterruptedException e) {;}
					}
					animal.sleep();
					System.out.println("와~ 잘잤다!");
					System.out.println("현재 체력 : " + animal.life);
					break;
				case 3://산책하기
					if(animal.life > 1) {
						Quiz q = animal.walk(quiz);
						if(q.jackpot) {
							System.out.println("★★★★★★★★★★★잭 팟★★★★★★★★★★★★");
						}
						System.out.println(q.exercise);
						answer = sc.nextInt();
						
						if(q.answer == answer) {
							animal.feedCount += q.feedCount;
							System.out.println("와! 훌륭해요! 정답을 맞췄어요!");
							System.out.println("먹이를 " + q.feedCount + "개 획득했어요!");
							System.out.println("현재 " + animal.feed + " 개수 : " + animal.feedCount);
							break;
						}
						System.out.println("아이구... 아까워요! 다음에 다시 도전해보세요~!!");
						animal.life --;
						System.out.println("현재 체력 : " + animal.life);
						
						if(animal.life == 0) {
							System.out.println("체력이 없어요 ㅠㅠ 얼른 자야겠어요...");
							System.out.print("자는 중.");
							for (int i = 0; i < 3; i++) {
								System.out.print(".");
								try {Thread.sleep(1000);} catch (InterruptedException e) {;}
							}
							animal.sleep();
							System.out.println();
						}
					}else {
						System.out.println("체력이 없어요! 잠을 자고 오세요~!");
					}
					break;
				}
			}
		}
		
	}
}











