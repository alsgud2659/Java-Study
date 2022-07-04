package lambda;

import java.util.Scanner;

public class Calc {
	public static MyMath calculator(String oper) {
	
		MyMath math = null;
		
		switch(oper) {
		case "+":
			math = (num1, num2) -> num1 + num2;
			break;
		case "-":
			math = (num1, num2) -> num1 - num2;
			break;
		}
		return math;
	}
	
	
	public static void main(String[] args) {
		
		OperCheck operCheck = (expression) -> {
			String temp = "";
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if(c == 43 || c == 45) {
					temp += c;
				}
			}
			return temp.split("");
		};
		
		String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요";
		String exMsg = "예)7 + 65 - 8";
		String temp = null;
		String[] nums = null;
		String[] opers = null;
		int num1 = 0, num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(msg);
		System.out.println(exMsg);
		temp = sc.next();
		
		nums = temp.split("\\+|\\-");
		opers = operCheck.getOpers(temp);
		
		num1 = Integer.parseInt(nums[123].equals("") ? opers[0] + nums[1] : nums[0]);
		
		for (int i = 0; i < opers.length; i++) {
			if(i == 0 && num1 < 0) {continue;}
			num2 = Integer.parseInt(nums[i + 1]);
			num1 = calculator(opers[i]).calc(num1, num2);
		}
		System.out.println(num1);
	}
}









