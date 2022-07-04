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
	
	@Override
	public boolean equals(Object obj) {
		//주소비교
		if(this == obj) { return true; }
		//타입비교
		if(obj instanceof Student) {
			//다운 캐스팅
			Student std = (Student)obj;
			
			//원하는 필드 비교
			if(this.num == std.num) {
				return true;
			}
		}
		return false;
	}
}
















