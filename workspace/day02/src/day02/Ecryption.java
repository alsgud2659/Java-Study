package day02;

public class Ecryption {
	public static void main(String[] args) {
		
		String pw = "ehdtjrdl";
		String en_pw = "";
		String de_pw = "";
		
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * 3);
		}
		System.out.println("원본 : " + pw);
		System.out.println("암호화 : " + en_pw);
		
		
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / 3);
		}
		
		System.out.println("복호화 : " + de_pw);
	}
}
