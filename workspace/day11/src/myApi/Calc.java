package myApi;

/**
 * 
 * @author 한동석
 * <br>
 * 계산기
 * <br>
 * @since JDK11
 */
public class Calc {
	 /**
	    * 두 정수를 나누는 메소드
	    * @param num1 : 첫번째 정수(나눠지는 수)
	    * @param num2 : 두번째 정수(나누는 수)
	    * <br>
	    * 예시)
	    * <br>
	    * 사용 예 : div(10, 3)
	    * <br>
	    * 결과 : 3
	    * @throws ArithmeticException
	    * @see Math
	    */
	public void div(int num1, int num2) {
		System.out.println(num1 / num2);
	}
}
