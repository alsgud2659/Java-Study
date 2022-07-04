package obj;

import java.util.Random;

public class EqualsTest {
	public static void main(String[] args) {
		Random r1 = new Random();
		Random r2 = new Random();
		
//		System.out.println(r1 == r2);
		System.out.println(r1.equals(r2));
		
		r1 = r2;
//		System.out.println(r1 == r2);
		System.out.println(r1.equals(r2));
		
	}
}
