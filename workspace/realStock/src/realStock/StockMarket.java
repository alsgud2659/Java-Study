package realStock;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class StockMarket {
	public static void main(String[] args) {
		String[] btns = {"매도하기", "나가기"};
		int choice  = 0;
		Scanner sc = new Scanner(System.in);
		Bank user = new Bank();
		Thread t = new Thread(user);
		
		System.out.println("투자액 : ");
		user.depositMoney = sc.nextInt();
		if(user.depositMoney > 0) {
			user.stockMoney = user.depositMoney;
			t.start();
			while(true) {
				choice = JOptionPane.showOptionDialog(null, "인생은 주식이다.", "주식마켓", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, btns, null);
				
				if(choice == 1) {
					System.exit(0);
				}
				
				if(choice == 0) {
					t.interrupt();
					try {t.join();} catch (InterruptedException e) {;}
					user.sell();
					break;
				}
			}
		}
	}
}
