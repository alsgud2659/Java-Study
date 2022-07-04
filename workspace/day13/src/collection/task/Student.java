package collection.task;

//학생 한 명이 추가 될 때마다 번호는 자동으로 증가된다.
//아래 작성된 필드의 접근자는 private으로 한다.
public class Student {
	private static int seq;
	//번호, 이름
	private int num;
	private String name;
	//국어, 영어, 수학 점수
	private int[] arScore;
	
	//초기화 블럭
	//클래스가 JVM에 로드될 때 딱 한 번만 사용할 로직 작성
	static {
		System.out.println("★ 학생관리 프로그램 ★");
	}
	
	//인스턴스 블럭
	//객체화 시 항상 실행되는 영역.
	{
		this.num = ++seq;
	}
	
	public Student() {;}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int[] arScore) {
		this.name = name;
		this.arScore = arScore;
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

	public int[] getArScore() {
		return arScore;
	}

	public void setArScore(int[] arScore) {
		this.arScore = arScore;
	}
	
	@Override
	public String toString() {
		String str = num + "\t" + name + "\t\t";
		int total = 0;
		double avg = 0.0;
		
		for (int i = 0; i < arScore.length; i++) {
			str += arScore[i] + "\t";
			total += arScore[i];
		}
		
		avg = (double)total / arScore.length;
		avg = Double.parseDouble(String.format("%.2f", avg));
		
		str += total + "\t" + avg;
		return str;
	}
}










