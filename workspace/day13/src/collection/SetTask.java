package collection;

import java.util.HashSet;

public class SetTask {
	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<>();
		Student std = new Student(1, "한동석");
		
		System.out.println(std.equals(new Student(1, "한동석")));
		
		set.add(std);
		set.add(new Student(1, "한동석"));
		
		System.out.println(set.size());
		
	}
}
