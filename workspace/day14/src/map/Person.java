package map;

public class Person {
	private int num;
	private String name;
	
	public Person() {;}

	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
