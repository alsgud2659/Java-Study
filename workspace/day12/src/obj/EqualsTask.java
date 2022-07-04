package obj;

public class EqualsTask {
	public static void main(String[] args) {
		Student std = new Student(1, "한동석");
		//학생의 번호가 같다면 true가 나올 수 있도록 equals()를 재정의 하기
		System.out.println(std.equals(new Student(1, "한동석")));
	}
}