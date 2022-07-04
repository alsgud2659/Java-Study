package bank;

import java.util.Random;

public class Dongseok extends Bank implements Runnable{
	
	int stockMoney = 0;
	int depositMoney = 0;
	Thread userThread;
	
	@Override
	public void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
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
		if(r.nextInt(2) == 0) { rating *= -1; }
		stockMoney *= (100 + rating) * 0.01;
				
		return true;
	}
	
	//매도
	public void sell() {
		this.setMoney(this.getMoney() + stockMoney);
	}
	
	//run() 재정의
	@Override
	public void run() {
		//- 투자금액은 전재산보다 작아야한다.
		if(this.getMoney() >= depositMoney) {
			this.setMoney(this.getMoney() - depositMoney);
			
			try {
				while(true) {
					if(!stock()) {break;}
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
		}else {
			System.out.println("잔액 부족");
		}
	}
}










