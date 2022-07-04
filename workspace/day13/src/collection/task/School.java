package collection.task;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
	public static void main(String[] args) {
		StudentField sf = new StudentField();
		Scanner sc = new Scanner(System.in);
		
		Student std1 = new Student("홍길동");
		Student std2 = new Student("홍길동");
		
		int[] arScore1 = {50, 60, 88};
		int[] arScore2 = {80, 70, 78};
		
		std1.setArScore(arScore1);
		std2.setArScore(arScore2);
		
		//추가
		sf.insert(std1);
		sf.insert(std2);
//		===========================================
		String msg = "번호\t이름\t\t국어\t영어\t수학\t총점\t평균";
		String[] subjects = {"국어", "영어", "수학"};
		String name = null;
		int num = 0;
		int subjectNumber = 0;
		int score = 0;
		ArrayList<Student> students = null;
		Student student = new Student();
		
		//수정
		//사용자가 선택한 학생의 번호,
		//선택한 과목, 입력한 점수로 수정 완성시키기
//		System.out.print("이름 : ");
//		name = sc.next();
//		
//		students = sf.selectNames(name);
//		
//		if(students.size() > 1) {//동명이인이 있을 때
//			System.out.println(msg);
//			for (int i = 0; i < students.size(); i++) {
//				//학생들의 정보 출력
//				System.out.println(students.get(i));
//			}
//			//사용자가 수정하고 싶은 학생 번호 입력
//			num = sc.nextInt();
//			
//		}else if(students.size() != 0) {//동명이인이 없을 때
//			//같은 이름이 없기 때문에 이름으로 해당 학생의 번호 검사
//			num = sf.getNumOfStudent(name);
//			
//		}else {//학생이 없을 때
//			System.out.println("검색 결과가 없습니다.");
//		}
//		
//		if(num != 0) { //학생이 한 명이라도 있을 때
//			System.out.println("수정하실 과목을 선택하세요");
//			for (int i = 0; i < subjects.length; i++) {
//				System.out.println(i + 1 + ". " + subjects[i]);
//			}
//			
//			//수정할 과목 번호 입력
//			subjectNumber = sc.nextInt();
//			
//			System.out.print(subjects[subjectNumber - 1] + " 점수 : ");
//			//새로운 점수 입력
//			score = sc.nextInt();
//			
//			//번호로 학생의 전체정보 가져오기
//			student = sf.getStudent(num);
//			//학생의 알맞은 과목에 새로운 점수로 수정한다.
//			student.getArScore()[subjectNumber - 1] = score;
//			
//			//위에서 주소에 직접 접근하여 수정하기 때문에 update()를 사용할 필요는 없다.			
//			if(sf.update(student)) {
//				System.out.println("수정 성공");
//				//수정 내용 확인
//				System.out.println(msg);
//				System.out.println(student);
//			}else {
//				System.out.println("수정 실패");
//			}
//		}
		
		//삭제
		System.out.print("이름 : ");
		name = sc.next();
		
		students = sf.selectNames(name);
		
		if(students.size() > 1) {//동명이인이 있을 때
			System.out.println(msg);
			for (int i = 0; i < students.size(); i++) {
				//학생들의 정보 출력
				System.out.println(students.get(i));
			}
			//사용자가 수정하고 싶은 학생 번호 입력
			num = sc.nextInt();
			
		}else if(students.size() != 0) {//동명이인이 없을 때
			//같은 이름이 없기 때문에 이름으로 해당 학생의 번호 검사
			num = sf.getNumOfStudent(name);
			
		}else {//학생이 없을 때
			System.out.println("검색 결과가 없습니다.");
		}
		
		if(num != 0) { //학생이 한 명이라도 있을 때
			if(sf.delete(num)) {
				System.out.println("삭제 성공");
				System.out.println(msg);
				
				students = sf.selectAll();
				
				for (int i = 0; i < students.size(); i++) {
					System.out.println(students.get(i));
				}
			}else {
				System.out.println("삭제 실패");
			}
		}
	}
}



























