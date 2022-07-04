package obj;

public class Student {
	int num;
	String name;

	public Student() {;}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name;
	}
}
