package bank;

public class Shinhan extends Bank{
	@Override
	public int getBalance() {
		this.setMoney((int)(getMoney() * 0.5));
		return super.getBalance();
	}
}
