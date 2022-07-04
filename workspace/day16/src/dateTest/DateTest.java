package dateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date today = new Date(System.currentTimeMillis());
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 EEE");
		System.out.println(sdf.format(today));
		
		today.setYear(120); // 1900년부터 시작점이기 때문에 전달한 정수와 더하여 년도가 설정된다.
		today.setMonth(0); // 월은 0부터 시작한다.
		today.setDate(17);
		today.getDay(); // 0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 =Thursday, 5 = Friday, 6 = Saturday
		System.out.println(sdf.format(today));
		System.out.println(today.getDay());
	}
}
