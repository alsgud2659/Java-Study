package collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		HashSet<String> fruitSet = new HashSet<>();
		fruitSet.add("수박");
		fruitSet.add("자두");
		fruitSet.add("망고");
		fruitSet.add("딸기");
		fruitSet.add("사과");
		fruitSet.add("사과");
		fruitSet.add("사과");

		System.out.println(fruitSet.toString());
		System.out.println(fruitSet.contains("자두"));
		
		Iterator<String> iter = fruitSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}










