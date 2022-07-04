package map;

public class Student extends Person{
	//실행 순서
	//1. super()
	//2. {}
	//3. this()
	
	{
		System.out.println(this.getNum() + "번 " + this.getName() + "님이 추가되었습니다.");
	}
	
	public Student() {;}

	public Student(int num, String name) {
		super(num, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(std.getNum() == this.getNum()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getNum();
	}
	
}








