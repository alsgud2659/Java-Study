package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		//KEY를 Student 타입으로, VALUE를 ArrayList 타입으로 설정하여 HashMap을 선언한다.
		HashMap<Student, ArrayList<Integer>> studentMap = new HashMap<>();
		
		//학생 객체 선언
		Student std1 = new Student(1, "한동석");
		Student std2 = new Student(2, "홍길동");
		Student std3 = new Student(1, "이순신");
		
		//asList(T ...) : 배열을 리스트로 변경시켜주는 메소드, 배열을 전달하지 않고 여러 개의 값을 전달해도 List로 리턴해준다.
		Integer[] arData = {100, 90, 70};
		ArrayList<Integer> std1Scores = new ArrayList<>(Arrays.asList(arData));
		ArrayList<Integer> std2Scores = new ArrayList<>(Arrays.asList(100, 90, 70));
		ArrayList<Integer> std3Scores = new ArrayList<>(Arrays.asList(20, 50, 60));
		
		//HashMap에 학생 2명의 정보와 각 시험 점수를 넣어준다.
		studentMap.put(std1, std1Scores);
		studentMap.put(std2, std2Scores);
		
		//equals()와 hashCode()를 재정의 한 후 결과를 직접 확인한다.
//		System.out.println(std1.equals(std3));
//		System.out.println(std1.hashCode() == std2.hashCode());
//		System.out.println(std1.hashCode() == std3.hashCode());
//		System.out.println(studentMap.containsKey(std3));
		
		//학생의 이름 변경
		//학생의 이름을 변경하기 위해서는 HashMap에서 Key에 해당하는 작업이기 때문에
		//Key만 분리하여 작업한다.
		Iterator<Student> iter = studentMap.keySet().iterator();
		while(iter.hasNext()) {
			Student std = iter.next();
			//학생 3번과 같은 번호를 가진 학생을 조회한 후
			//학생 3번의 이름으로 변경해준다.
			if(std.getNum() == std3.getNum()) {
				std.setName(std3.getName());
//				System.out.println(std.getName());
			}
		}
		
//		//학생 1번의 점수를 수정한다.
//		studentMap.put(std3, std3Scores);
//		System.out.println(studentMap);
		
//		빠른 for문(향상된 for문, forEach)
		
//		int[] datas = {3, 4, 5};
//		for(int data : datas) {
//			System.out.println(data);
//		}
		
		//학생별 점수와 평균 점수, 총 점(values())
		
		//학생의 수 만큼 배열 선언
		int[] arTotal = new int[studentMap.size()];
		double[] arAvg = new double[studentMap.size()];
		
		//전체 점수
		int total = 0;
		//전체 평균
		double avg = 0.0;
		int idx = 0;
		
		//HashMap에서 점수에 대한 작업을 해야 하므로 KEY는 필요없다.
		//따라서 Value를 분리하여 Collection에 담아준다.
		//Collection은 여러 개의 ArrayList를 담고 있다.
		Collection<ArrayList<Integer>> scores = studentMap.values();
		for(ArrayList<Integer> scoreList : scores) {//각 학생의 점수들을 scoreList에 담아준다.
			for(int score : scoreList) {//각 학생의 점수들에서 각 점수를 분리한다.
				arTotal[idx] += score;//idx번째 방에 학생의 점수를 누계한다.
				total += score;//전체 점수에 학생의 점수를 누계한다.
				System.out.print(score + "\t");
			}
			//학생 별 평균 점수 구하기
			arAvg[idx] = (double)arTotal[idx] / scoreList.size();
			arAvg[idx] = Double.parseDouble(String.format("%.2f", arAvg[idx]));
			
			//전체 평균 구하기
			avg =(double)total /  (scoreList.size() * studentMap.keySet().size());
			avg = Double.parseDouble(String.format("%.2f", avg));
			
			System.out.println(arAvg[idx] + "\t" + arTotal[idx]);
			
			//학생 한 명의 연산이 모두 끝나면 다음 학생으로 넘어가야 하기 때문에
			//idx를 1 증가시켜준다.
			idx++;
		}
		
		//전체 학생의 평균 점수보다 높은 학생을 찾아낸다(우수 학생으로 출력)
		
		//점수로 학생의 이름을 가져와하기 때문에 KEY와 VALUE 모두 필요하다.
		//이 때 entrySet()을 사용하여 한 쌍씩 모든 쌍을 가져온다.
		//이 때 각 쌍은 Entry타입이다.
		Iterator<Entry<Student, ArrayList<Integer>>> iterator = studentMap.entrySet().iterator();
		String msg = "";
		String names = "";
		while(iterator.hasNext()) {
			//한 쌍씩 가져와서 entry에 담는다.
			Entry<Student, ArrayList<Integer>> entry = iterator.next();
			
			//학생의 총점
			int stdTotal = 0;
			//학생의 평균
			double stdAvg = 0.0;
			
			//학생의 점수를 하나씩 score에 담고 stdTotal에 누계한다.
			for(int score : entry.getValue()) {
				stdTotal += score;
			}
			//학생의 평균 점수
			stdAvg = (double)stdTotal / entry.getValue().size();
			msg = "우수 장학생 명단\n";
			if(stdAvg > avg) { //학생의 평균점수가 전체 평균 점수보다 높다면
				names = entry.getKey().getName() + "\n";
			}
		}
		if(!names.equals("")) { //평균 점수보다 높은 학생이 한 명이라도 있다면
			System.out.print(msg + names);
		}else { // 우수 장학생이 없는 경우
			System.out.println("우수 장학생이 없습니다.");
		}
	}
}






