package day05;

import java.util.Scanner;

class SuperCar{
	
	String brand;
	String color;
	int price;
	String pw = "0000";
	boolean check;
	int policeCount;
	
	public SuperCar(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public SuperCar(String brand, String color, int price, String pw) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.pw = pw;
	}
	
	//[심화]
	//시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
	//입력한 비밀번호가 3회 연속 실패하면 "경찰 출동"메세지를 출력한다.
	
	boolean checkPw(String pw){
		//문자열 비교 시 equals()를 사용!
		return this.pw.equals(pw);
	}
	
	//시동 켜기(만약 이미 시동이 켜져있다면 경고 메세지 출력)
	boolean engineStart() {
		if(!check) {
			return true;
		}
		return false;
	}
	//시동 끄기(만약 이미 시동이 꺼져있다면 경고 메세지 출력)
	boolean engineStop() {
		if(check) {
			return true;
		}
		return false;
	}
	
}

public class Shop {
	public static void main(String[] args) {
		SuperCar ferrari = new SuperCar("Ferrari", "Red", 35_000, "1234");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String pw = null;
		
		while(true) {
			System.out.println("1.시동켜기\n2.시동끄기");
			choice = sc.nextInt();
			
			if(choice == 1) {
				if(ferrari.engineStart()) {
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					if(ferrari.checkPw(pw)) {
						ferrari.check = true;
						ferrari.policeCount = 0;
						System.out.println("시동 켜짐");
					}else {
						ferrari.policeCount++;
						System.out.println("비밀번호" + ferrari.policeCount + "회 오류");
						if(ferrari.policeCount == 3) {
							System.out.println("경찰 출동");
							break;
						}
					}
					
				}else {
					System.out.println("시동이 이미 켜져있습니다.");
				}
				
			}else if(choice == 2) {
				if(ferrari.engineStop()) {
					ferrari.check = false;
					System.out.println("시동 꺼짐");
				}else {
					System.out.println("시동이 이미 꺼져있습니다.");
				}
			}
			
		}

//		if(ferrari.engineStart()) {
//			System.out.println("시동 킴");
//		}else {
//			System.out.println("이미 시동이 켜져있습니다.");
//		}
//		
//		if(ferrari.engineStop()) {
//			System.out.println("시동 끔");
//		}else {
//			System.out.println("이미 시동이 꺼져있습니다.");
//		}
	}
}
















