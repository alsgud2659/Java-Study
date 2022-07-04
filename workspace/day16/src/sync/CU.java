package sync;

import javax.swing.JOptionPane;

public class CU {
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
	}
}
