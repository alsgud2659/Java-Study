package lambda;

import java.util.HashMap;

public class StreamTest {
	public static void main(String[] args) {
		HashMap<String, Integer> chinaTown = new HashMap<>();
		
		chinaTown.put("짜장면", 4500);
		chinaTown.put("짬뽕", 5500);
		chinaTown.put("탕수육", 18000);
		
		//여러 개를 가지고 있는 컬렉션 객체에서 forEach메소드를 사용할 수 있다.
		//forEach메소드에 Consumer인터페이스 타입의 값을 전달해야 한다.
		//Consumer는 함수형 인터페이스이기 때문에 람다식 사용할 수 있다.
		//매개변수에는 컬렉션 객체 안에 들어있는 값들이 순서대로 담기고,
		//화살표 뒤에서는 구현하고 싶은 문장을 작성한다.
		chinaTown.values().forEach(price -> System.out.println(price));
	}
}
