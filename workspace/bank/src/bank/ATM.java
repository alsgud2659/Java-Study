package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Bank user = null;
		//은행 선택
		//1. 1번 은행
		//2. 2번 은행
		//3. 3번 은행
		String msg = "1. 동석은행\n2. 국민은행\n3. 신한은행\n4. 나가기";
		int bankNum = 0;
		//메인 메뉴
		String menu = "-1. 매도하기\n0. 주식\n1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 계좌내역\n7. 은행 선택";
		int choice = 0;
		String account = "";
		int lengthOfAccount = 0;
		String name = null;
		String phone = null;
		String pw = null;
		int money = 0;
		
		//핸드폰 길이 검사
		boolean condition1 = false;
		//핸드폰 문자 검사
		boolean condition2 = false;
		
		while(true) {
			System.out.println(msg);
			bankNum = sc.nextInt();
			if(bankNum == 4) { break; }
			
			while(true) {
				System.out.println(menu);
				choice = sc.nextInt();
				
				//7. 나가기(은행 다시 선택)
				if(choice == 7) { break; }
				
				switch(choice) {
				case -1: //매도하기
					if(bankNum != 1) {break;}
					
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					
					if(user != null) {
						Dongseok dongseokUser = (Dongseok)user;
						if(dongseokUser.userThread == null) {
							System.out.println("현재 투자금이 없습니다.");
							break;
						}
						
						dongseokUser.userThread.interrupt();
						try {dongseokUser.userThread.join();} catch (InterruptedException e) {;}
						dongseokUser.sell();
						dongseokUser.userThread = null;
					}else {
						System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					}
					break;
				case 0: //주식
					if(bankNum != 1) {break;}
					
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					
					if(user != null) {
						Dongseok dongseokUser = (Dongseok)user;
						//현재 주식중인지 검사
						if(dongseokUser.userThread != null) {
							System.out.println("매도 후 이용해주세요.");
							continue;
						}
						
						System.out.print("투자액 : ");
						dongseokUser.depositMoney = sc.nextInt();
						if(dongseokUser.depositMoney <= 0 ) {
							System.out.println("투자액을 잘못 입력하셨습니다.");
							continue;
						}
						
						dongseokUser.stockMoney = dongseokUser.depositMoney;
						
						Thread t = new Thread(dongseokUser);
						dongseokUser.userThread = t;
						dongseokUser.userThread.start();
					}else {
						System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					}
					
					break;
				case 1: //계좌 개설
					//1. 계좌 개설
					//	- 6자리 랜덤 계좌번호 (999999)
					//	- 기존 고객의 계좌번호와 중복이 없는 번호로 개설해야 한다.
					Bank[] arBank = {new Dongseok(), new Kookmin(), new Shinhan()};
					user = arBank[bankNum - 1];
					
					do {
						account = "";
						account += r.nextInt(1000000);
						lengthOfAccount = 6 - account.length();
						if (lengthOfAccount != 0) {
							for (int i = 0; i < lengthOfAccount; i++) {
								account = "0" + account;
							}
						} 
					}while (Bank.checkAccount(account) != null || account.equals("000000"));
					
					System.out.print("예금주 : ");
					name = sc.next();
					
					// - 핸드폰 번호는 숫자만 입력하도록 하고, 문자가 포함되면 안되며, 0~9사이의 정수여야 한다.
					do {
						System.out.println("핸드폰 번호를 입력해주세요.\n예)01012345678");
						phone = sc.next();
						
						condition1 = phone.length() != 11;
						condition2 = false;
						
						for (int i = 0; i < phone.length(); i++) {
							int result = phone.charAt(i) - 48;
							if(result < 0 || result > 9) {
								condition2 = true;
							}
						}
						
					} while(condition1 || condition2 || Bank.checkPhone(phone) != null);
					
					
					// - 비밀번호는 4자리로만 입력하도록 한다.
					do {
						System.out.print("비밀번호 : ");
						pw = sc.next();
						condition1 = pw.length() != 4;
						condition2 = false;
						
						for (int i = 0; i < pw.length(); i++) {
							int result = pw.charAt(i) - 48;
							if(result < 0 || result > 9) {
								condition2 = true;
							}
						}
					} while(condition1 || condition2);
					
					user.setAccount(account);
					user.setName(name);
					user.setPhone(phone);
					user.setPw(pw);
					user.setBankNum(bankNum);
					
					Bank.banks[bankNum - 1][Bank.arCount[bankNum - 1]] = user;
					
					Bank.arCount[bankNum - 1] ++;
					System.out.println("*************계좌 개설 완료*************");
					System.out.println(name + "님의 계좌번호 : " + account);
					System.out.println("※ 계좌번호는 다시 알려드리기 어렵습니다. 분실 시 계좌번호가 변경되오니 참고해주세요.");
					break;
					
				case 2: // 입금하기
					//2. 입금하기
					//	- 로그인(계좌번호, 비밀번호)
					//	- 계좌를 개설한 은행에서만 입금 가능
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					
					if(user != null) {
						if(user.getBankNum() != bankNum) {
							System.out.println("계좌를 개설한 은행에서만 입금하실 수 있습니다.");
							break;
						}
						System.out.print("입금액 : ");
						money = sc.nextInt();
						
						if(money < 0) {
							System.out.println("음수는 입력하실 수 없습니다.");
							continue;
						}
						
						user.deposit(money);
						System.out.println(user.getName() + "님의 현재 잔액 : " + user.getMoney() + "원");
						user.writeLog(user, money, true);
						break;
					}
					System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					break;
				case 3: // 출금하기
					//3. 출금하기
					//	- 로그인(계좌번호, 비밀번호)
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					if(user != null) {
						System.out.print("출금액 : ");
						money = sc.nextInt();
						
						
						if(money < 0) {
							System.out.println("음수는 입력하실 수 없습니다.");
							continue;
						}
						
						if(user.getMoney() < money * (user.getBankNum() == 2 ? 1.5 : 1.0)) {
							System.out.println("잔액이 부족합니다.");
							continue;
						}
						
						user.withdraw(money);
						System.out.println(user.getName() + "님의 현재 잔액 : " + user.getMoney() + "원");
						user.writeLog(user, money, false);
						break;
					}
					System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					break;
				case 4: // 잔액조회
					//4. 잔액조회
					//	- 로그인(계좌번호, 비밀번호)
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					if(user != null) {
						System.out.println(user.getName() + "님의 현재 잔액 : " + user.getBalance() + "원");
						if(bankNum == 1) {
							Dongseok dongseokUser = (Dongseok)user;
							if(dongseokUser.userThread != null) {
								System.out.println("주식 평가 금액 : " + dongseokUser.stockMoney + "원");
								System.out.println("수익률 : " + ((dongseokUser.stockMoney - dongseokUser.depositMoney) / (double)dongseokUser.depositMoney) * 100);
							}else {
								System.out.println("야 주식 한 번 너도 해봐. 너도 람보르기니 타야지.");
							}
						}
						if(user.getMoney() == 0) {
							System.out.println("넌 소중해");
						}
					}else {
						System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					}
					break;
				case 5: // 계좌번호 찾기
					//5. 계좌번호 찾기
					//	- 휴대폰 번호, 비밀번호 입력
					//	- 새로운 계좌번호 부여
					System.out.print("핸드폰 번호 : ");
					phone = sc.next();
					user = Bank.checkPhone(phone);
					if(user != null) {
						System.out.print("비밀번호 : ");
						pw = sc.next();
						if(user.getPw().equals(pw)) {
							do {
								account = "";
								account += r.nextInt(1000000);
								lengthOfAccount = 6 - account.length();
								if (lengthOfAccount != 0) {
									for (int i = 0; i < lengthOfAccount; i++) {
										account = "0" + account;
									}
								} 
							}while (Bank.checkAccount(account) != null || account.equals("000000"));
							user.changeLog(user.getAccount(), account);
							user.setAccount(account);
							System.out.println("*************계좌 변경 완료*************");
							System.out.println(name + "님의 계좌번호 : " + account);
							System.out.println("※ 계좌번호는 다시 알려드리기 어렵습니다. 분실 시 계좌번호가 변경되오니 참고해주세요.");
						}else {
							System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
						}
					}else {
						System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					}
					break;
				case 6: // 거래내역
					//선택★ 6. 계좌내역(거래내역) - 연결(+=)
					//	- 계좌번호, 예금주, 입금인지 출금인지, 입금액 또는 출금액, 현재 잔액 출력
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					user = Bank.login(account, pw);
					if(user != null) {
						System.out.println(user.getLog());
					}else {
						System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
					}
					
					//	- 만약 계좌번호 변경 시 이전 거래 내역에서 계좌번호를 신규 계좌번호로 수정(split())
					break;
				}
			}
		}
	}
}








