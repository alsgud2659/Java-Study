package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		//싱글턴 패턴
		//객체를 하나만 생성하도록 설계하며, 생성된 객체를 어디에서든지 접근할 수 있도록 한다.		
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(today.getTime()));
		
		today.set(1999, 11, 4);
		System.out.println(sdf.format(today.getTime()));
		
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH) + 1);
	}
}
