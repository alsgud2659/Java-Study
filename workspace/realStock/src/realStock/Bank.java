package realStock;

import java.util.Random;

public class Bank implements Runnable{
	int money;
	int stockMoney = 0;
	int depositMoney = 0;
	
	public void deposit(int money) {
		money *= 0.5;
		this.money += money;
	}
	
	//주식
	public boolean stock() {
		Random r = new Random();
		int rating = 0;
		
		if(r.nextInt(100) == 0) {
			stockMoney = 0;
			return false;
		}
		
		rating = r.nextInt(30) + 1;
		if(r.nextInt(10) == 0) { rating *= -1; }
		stockMoney *= (100 + rating) * 0.01;
				
		return true;
	}
	
	//매도
	public void sell() {
		this.money += stockMoney;
	}
	
	//run() 재정의
	@Override
	public void run() {
		//- 투자금액은 전재산보다 작아야한다.
		money -= depositMoney;
		
		try {
			while(true) {
				if(!stock()) {System.out.println("상장이 폐지되었습니다. 바람을 쐬고 오세요."); break;}
				System.out.print(stockMoney +"원(");
				System.out.println(((stockMoney - depositMoney) / (double)depositMoney) * 100 + "%)");
					Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			//주식 전 투자금액 출력
			System.out.println("================================");
			System.out.println("주식 전 투자 금액 : " + depositMoney +"원");
			//주식 후 투자금액 출력
			System.out.println("주식 후 투자 금액 : " + stockMoney +"원");
			//수익률 출력
			System.out.println("수익률 : " + ((stockMoney - depositMoney) / (double)depositMoney) * 100 + "%");
			System.out.println("================================");
		}
	}
}