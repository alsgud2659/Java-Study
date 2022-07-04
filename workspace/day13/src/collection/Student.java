package collection;

public class Student {
	int num;
	String name;
	
	public Student() {;}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(std.num == this.num) {
				return true;
			}
		}
		return false;
	}
	
	//eqauls를 재정의 했다면, 반드시 hashCode도 재정의 해야한다.
	@Override
	public int hashCode() {
		return this.num;
	}
	
}











