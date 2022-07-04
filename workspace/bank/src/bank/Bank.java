package bank;

public class Bank {
	//모든 은행의 고객을 관리하는 DB
	public static Bank[][] banks = new Bank[3][100];
	
	//각 은행별 고객 수 - 기존 고객 수 만큼만 검사하기 위해서
	public static int[] arCount = new int[banks.length];
	
//	예금주, 계좌번호, 핸드폰번호, 비밀번호, 잔액
	private String name;
	private String account;
	private String phone;
	private String pw;
	private int money;
	private String log = "";
	private int bankNum;
	
	public Bank() {}

	public Bank[][] getBanks() {
		return banks;
	}

	public void setBanks(Bank[][] banks) {
		this.banks = banks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	public int getBankNum() {
		return bankNum;
	}

	public void setBankNum(int bankNum) {
		this.bankNum = bankNum;
	}

	//- 계좌번호 중복검사
	public static Bank checkAccount(String account) {
		Bank user = null;
		for (int i = 0; i < banks.length; i++) {
			for (int j = 0; j < arCount[i]; j++) {
				if(banks[i][j].account.equals(account)) {
					//중복이 있을 때
					user = banks[i][j];
					break;
				}
				if(j != arCount[i]) {break;}
			}
		}
		return user;
	}
	
	//- 핸드폰 중복검사(핸드폰 번호를 매개변수로 받은 후 DB에서 검사)
	public static Bank checkPhone(String phone) {
		Bank user = null;
		for (int i = 0; i < banks.length; i++) {
			for (int j = 0; j < arCount[i]; j++) {
				if(banks[i][j].phone.equals(phone)) {
					//중복이 있을 때
					user = banks[i][j];
					break;
				}
				if(j != arCount[i]) {break;}
			}
		}
		return user;
	}
	
	//- 로그인(계좌번호와 비밀번호)
	public static Bank login(String account, String pw) {
		Bank user = checkAccount(account);
		if(user != null) { //계좌번호가 있다면
			if(user.pw.equals(pw)) { //비밀번호 비교
				return user;
			}
		}
		return null;
	}
	
	//- 입금
	public void deposit(int money) {
		this.money += money;
	}
	
	//- 출금(잔액검사)
	public void withdraw(int money) {
		this.money -= money;
	}
	
	//- 잔액조회(잔액이 0원이 있을 경우 "힘내세요" 또는 "넌 소중해" 출력)
	public int getBalance() {
		return this.money;
	}
	
	public void writeLog(Bank user, int money, boolean deposit) {
		log += user.account + ", " + user.name + ", " + (deposit ?  "입금" : "출금") + money + "원 / " + user.money + "원\n";
	}
	
	public void changeLog(String oldAccount, String newAccount) {
		String[] lines = log.split("\n");
		String result = "";
		
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(", ");
			if(line[0].equals(oldAccount)) {
				result += newAccount + lines[i].substring(lines[i].indexOf(",")) + "\n";
				continue;
			}
			result += lines[i];
		}
		log = result;
	}
}







