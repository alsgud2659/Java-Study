package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		BreadPlate plate = BreadPlate.getInstance();
		Thread makerThread = new Thread(maker);
		
		String[] btns = {"빵 먹기", "나가기"};
		
		ImageIcon icon = new ImageIcon("src/img/test.gif");
		
		makerThread.start();
		
		int choice = 0;
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, icon, btns, null);
			
			if(choice == 0) {
				plate.eatBread();
			}else {
				//빵 만들기 쓰레드 종료하기(변수로 해결)
//				maker.setExit(true);
//				makerThread.interrupt();
				System.exit(0);
				break;
			}
		}
	}
}
