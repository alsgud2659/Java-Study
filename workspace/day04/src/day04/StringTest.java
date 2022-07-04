package day04;

public class StringTest {
	public static void main(String[] args) {
		String data = "ABC";
		String scores = "10,20,30";
		
		System.out.println(data.length());
		System.out.println(data.charAt(1));
		System.out.println(scores.split(",")[1]);
		System.out.println(data.split("")[1]);
	}
}
