package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import dao.UserDAO;
import vo.UserVO;

public class View {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		//회원 탈퇴 복구
		Scanner sc = new Scanner(System.in);
		String id = null;
		String pw = null;
		int userNumber = 0;
		
		dao.login("hds1111", "abcd");
		userNumber = UserDAO.userNumber;
		
		ArrayList<UserVO> users = dao.findId(dao.selectUser().getPhoneNumber());
		users = (ArrayList<UserVO>)users.stream().filter(user -> user.getStatus() == 0).collect(Collectors.toList());
		if(users.size() != 3) {
			dao.restore();
		}else {
			System.out.println("복구하시기 위해서는 기존 계정 중 한 개를 탈퇴하셔야 합니다.");
			System.out.println("탈퇴를 원하시면 계정의 아이디와 비밀번호를 입력하시고,");
			System.out.println("취소하시려면 -1을 입력하세요.");
			users.stream().map(user -> user.getId()).forEach(System.out::println);
			
			id = sc.next();
			if(id.equals("-1")) {
				System.out.println("취소 되었습니다.");
			}else {
				pw = sc.next();
				
				if(dao.login(id, pw) == 0) {
					System.out.println("탈퇴할 " + id + "계정의 비밀번호를 다시 입력해주세요.");
					
					if(dao.delete(sc.next())) {
						System.out.println("탈퇴 성공");
						
						UserDAO.userNumber = userNumber;
						dao.restore();
						System.out.println("복구 성공");
						
					}else {
						System.out.println("탈퇴 실패");
						
					}
					
				}else {
					System.out.println("실패");
				}
			}
			
		}
		
		//아이디 중복 검사
//		int status = dao.checkId("hds5555");
//		
//		switch(status) {
//		case -1:
//			System.out.println("사용 가능한 아이디입니다.");
//			break;
//		case 0:
//			System.out.println("중복된 아이디입니다.");
//			break;
//		case 1:
//			System.out.println("사용할 수 없는 아이디입니다.");
//			break;
//		}
		
		//회원 탈퇴
//		Scanner sc = new Scanner(System.in);
//		
//		int status = dao.login("hds1111", "abcd");
//		if(status == 0) {
//			System.out.print("비밀번호 : ");
//			dao.delete(sc.next());
//			System.out.println("회원 탈퇴 성공");
//		}else {
//			System.out.println("회원탈퇴가 불가능한 계정입니다.");
//		}
		
		//정보 수정(비밀번호 변경)
//		Scanner sc = new Scanner(System.in);
//		String id = null;
//		String pw = null;
//		
//		System.out.print("아이디 : ");
//		id = sc.next();
//		
//		System.out.print("비밀번호 : ");
//		pw = sc.next();
//		
//		int status = dao.login(id, pw);
//		
//		if(status == 0) {//일반 계정
//			System.out.print("새로운 비밀번호 : ");
//			pw = sc.next();
//			
//			UserVO user = dao.selectUser();
//			user.setPw(pw);
//			dao.updateInfo(user);
//			System.out.println("수정 완료");
//			
//		}else if(status == 1) {//탈퇴 계정
//			System.out.println("복구를 하시려면 비밀번호를, 취소는 -1을 입력하세요");
//			pw = sc.next();
//			
//			if(!pw.equals("-1")) {
//				dao.restore();
//				System.out.println("복구 완료");
//				
//				System.out.print("새로운 비밀번호 : ");
//				pw = sc.next();
//				
//				UserVO user = dao.selectUser();
//				user.setPw(pw);
//				dao.updateInfo(user);
//				System.out.println("수정 완료");
//			}
//			
//		}else {
//			System.out.println("로그인 실패");
//			
//		}
		
		
		//비밀번호 찾기
//		Scanner sc = new Scanner(System.in);
//		String phone = null;
//		String id = null;
//		
//		System.out.print("아이디 : ");
//		id = sc.next();
//		
//		if(dao.checkId(id) != -1) {
//			System.out.print("핸드폰 번호 : ");
//			phone = sc.next();
//			
//			dao.sendTempPw(phone);
//			dao.updatePw(id);
//			
//		}else {
//			System.out.println("없는 아이디입니다.");
//		}
		
		//아이디 찾기
//		Scanner sc = new Scanner(System.in);
//		String number = "";
		
//		dao.sendNumber("");
//		System.out.print("인증번호 : ");
//		number = sc.next();
//		
//		if(number.equals(UserDAO.number)) {
//			dao.findId("").stream().forEach(user -> {
//				if(user.getStatus() == 1) {
//					System.out.println(user.getId() + "[X]");
//				}else {
//					System.out.println(user.getId());
//				}
//			});
//		}else {
//			System.out.println("인증번호 불일치");
//		}
		//회원가입
//		vo.setId("hds8888");
//		vo.setPw("8888");
//		vo.setName("홍길동");
//		vo.setPhoneNumber("01040625261");
//		vo.setAge(20);
		
//		ArrayList<UserVO> users = dao.findId("01040625261");
//		int size = users.stream().filter(user -> user.getStatus() == 0).collect(Collectors.toList()).size();
//		
//		if(size != 3) {
//			dao.join(vo);
//		}
		
//		if(dao.checkJoin(vo.getPhoneNumber())) {
//			dao.join(vo);
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		
//		//로그인
//		if(dao.login("hds1111", "abcd") == 0) {
//			System.out.println("로그인 성공");
//			
//		}else {
//			System.out.println("로그인 실패");
//		}
		
		
		//아이디 중복검사
//		if(dao.checkId("hds9")) {
//			System.out.println("중복된 아이디");
//			
//		}else {
//			System.out.println("사용 가능한 아이디");
//			
//		}
	}
}
