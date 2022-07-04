package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.UserVO;

public class UserDAO {
	
//	값에 의미를 부여하기 위해 상수로 선언
//	private final static int ERROR_LOGIN = -1;
//	private final static int AVAILABLE_ID = -1;
	
	private static final int KEY = 3;
	public static String number;
	public static String tempPw;
	public static int userNumber;
	
	//DB와 연결한 객체
	Connection conn;
	//작성한 SQL문을 저장하고, 관리하고, 실행
	PreparedStatement pstm;
	//SQL문의 결과를 담아주는 객체
	ResultSet rs;
	
	//아이디 중복검사
	public int checkId(String id) {
		String query = "SELECT STATUS FROM TBL_USER WHERE ID = ?";
		int status = 0;
		try {
			//연결 객체 전달받기
			conn = DBConnecter.getConnection();
			
			//작성한 SQL문을 prepareStatement에 전달
			pstm = conn.prepareStatement(query);
			
			//?에 들어갈 값을 전달하여 SQL문 완성
			pstm.setString(1, id);
			
			//완성된 SQL문 실행, 결과를 ResultSet객체에 담기
			rs = pstm.executeQuery();
			
			//행 가져오기
			if(!rs.next()) { //가져올 행이 없다면 사용 가능한 아이디
				status = -1;
			}else { //행을 가져왔다면 해당 아이디의 상태를 status에 대입(0또는 1)
				//첫번째 열 가져오기
				status = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() SQL 오류");
			
		} finally {
			//열었던 객체들을 모두 닫아준다.
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				//닫을 때 문제 발생 시 예외 발생 후 강제종료해준다.
				throw new RuntimeException(e.getMessage());
			}
		}
		//아이디 중복검사 결과를 리턴한다(-1 : 사용 가능한 아이디, 0 : 중복된 아이디, 1 : 사용할 수 없는 아이디)
		return status;
	}
//	public boolean checkId(String id) {
//		String query = "SELECT COUNT(*) FROM TBL_USER WHERE ID = ?";
//		boolean check = false;
//		try {
//			//연결 객체 전달받기
//			conn = DBConnecter.getConnection();
//			
//			//작성한 SQL문을 prepareStatement에 전달
//			pstm = conn.prepareStatement(query);
//			
//			//?에 들어갈 값을 전달하여 SQL문 완성
//			pstm.setString(1, id);
//			
//			//완성된 SQL문 실행, 결과를 ResultSet객체에 담기
//			rs = pstm.executeQuery();
//			
//			//행 가져오기
//			rs.next();
//			//첫번째 열 가져오기
//			check = rs.getInt(1) == 1;
//			
//		} catch (SQLException e) {
//			System.out.println("checkId() SQL 오류");
//			
//		} finally {
//			//열었던 객체들을 모두 닫아준다.
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstm != null) {
//					pstm.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				//닫을 때 문제 발생 시 예외 발생 후 강제종료해준다.
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//		//아이디 중복검사 결과를 리턴한다(true : 중복있음, false : 중복없음)
//		return check;
//	}
	
	//회원가입
	public void join(UserVO user) {
		String query = "INSERT INTO TBL_USER " + 
				"(USERNUMBER, ID, PW, NAME, AGE, PHONENUMBER, STATUS) " + 
				"VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, 0)";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getId());
			pstm.setString(2, encrypt(user.getPw()));
			pstm.setString(3, user.getName());
			pstm.setInt(4, user.getAge());
			pstm.setString(5, user.getPhoneNumber());
			
			//SELECT를 제외한 다른 DML에서는 결과 테이블이 존재하지 않고 결과 건수만 존재한다.
			//이 때에는 executeUpdate()를 사용한다.
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("join() SQL 오류");
			
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류");
			
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//로그인
	public int login(String id, String pw) {
		String query = "SELECT USERNUMBER, STATUS FROM TBL_USER WHERE ID = ? AND PW = ? ";
		
		int status = 0;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
//			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			
			if(!rs.next()) { //로그인 실패
				status = -1;
				userNumber = -1;
			}else { //로그인 성공(STATUS가 0(일반) 또는 1(탈퇴))
				status = rs.getInt(2);
				userNumber = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("login() SQL 오류");
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return status;
	}
//	public boolean login(String id, String pw) {
//		String query = "SELECT USERNUMBER, COUNT(USERNUMBER) "
//				+ "FROM TBL_USER WHERE ID = ? AND PW = ? "
//				+ "GROUP BY USERNUMBER";
//		boolean check = false;
//		try {
//			conn = DBConnecter.getConnection();
//			pstm = conn.prepareStatement(query);
//			pstm.setString(1, id);
//			pstm.setString(2, encrypt(pw));
//			rs = pstm.executeQuery();
//			
//			rs.next();
//			check = rs.getInt(2) == 1;
//			
//			if(check) {userNumber = rs.getInt(1);}
//			else {userNumber = -1;}
//			
//		} catch (SQLException e) {
//			System.out.println("login() SQL 오류");
//			
//		} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstm != null) {
//					pstm.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//		return check;
//	}
	
	//암호화
	//아스키 코드
	//회원 가입과 로그인 부분에 적절히 사용한 뒤
	//main메소드에서 테스트 진행
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		
		return en_pw;
	}
	
	//아이디 찾기
	//1. 핸드폰 번호로 랜덤한 6자리 인증번호 전송(coolSMS API 사용하기)
	public void sendNumber(String phoneNumber) {
		String data = "0123456789";
		Random r = new Random();
		number = "";
		
		//6번 반복
		for (int i = 0; i < 6; i++) {
			//랜덤한 문자(0~9)가 6번 number에 누적되어 들어간다.
			number += data.charAt(r.nextInt(data.length()));
//			number += r.nextInt(10);
		}
		
		String api_key = "";
	    String api_secret = "";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", phoneNumber);
	    params.put("to", "");
	    params.put("from", "");
	    params.put("type", "SMS");
	    params.put("text", "인증번호 [" + number + "] 본인확인을 위해 입력해주세요.");
	    params.put("app_version", "test app 2.2"); // application name and version
	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
	
	//2. 전송된 인증번호 검사
	//3. 인증 성공 시 해당 아이디 출력
	//아이디 찾기 시 탈퇴 회원 표시하기
	//리턴타입을 ArrayList<UserVO>로 변경하기
	public ArrayList<UserVO> findId (String phoneNumber) {
		String query = "SELECT ID, STATUS FROM TBL_USER WHERE PHONENUMBER = ?";
		ArrayList<UserVO> users = new ArrayList<>();
		UserVO user = null;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phoneNumber);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(1));
				user.setStatus(rs.getInt(2));
				users.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("findId() SQL 오류");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return users;
	}
//	public ArrayList<String> findId (String phoneNumber) {
//		String query = "SELECT ID, STATUS FROM TBL_USER WHERE PHONENUMBER = ?";
//		ArrayList<String> ids = new ArrayList<>();
//		try {
//			conn = DBConnecter.getConnection();
//			pstm = conn.prepareStatement(query);
//			pstm.setString(1, phoneNumber);
//			rs = pstm.executeQuery();
//			
//			while(rs.next()) {
//				//결과 행으로부터 아이디를 가져와서 ArrayList에 넣어준다.
//				ids.add(rs.getString(1));
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("findId() SQL 오류");
//		} finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstm != null) {
//					pstm.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return ids;
//	}
	
	//비밀번호 찾기
	//임시 비밀번호 6자리 전송
	//0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+-=[]{};:/?
	public void sendTempPw(String phoneNumber) {
		String data = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+-=[]{};:/?";
		Random r = new Random();
		tempPw = "";
		
		for (int i = 0; i < 6; i++) {
			tempPw += data.charAt(r.nextInt(data.length()));
		}
		
		String api_key = "";
	    String api_secret = "";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", phoneNumber);
	    params.put("to", "");
	    params.put("from", "");
	    params.put("type", "SMS");
	    params.put("text", "임시비밀번호 [" + tempPw + "] 로그인 후 비밀번호를 변경해주세요.");
	    params.put("app_version", "test app 2.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
	
	public void updatePw(String id) {
		String query = "UPDATE TBL_USER SET PW = ? WHERE ID = ?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(tempPw));
			pstm.setString(2, id);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updatePw() SQL 오류");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//회원 정보 수정
	public void updateInfo(UserVO user) {
		String query = "UPDATE TBL_USER "
				+ "SET NAME = ?, AGE = ?, PHONENUMBER = ?, PW = ? "
				+ "WHERE USERNUMBER = ?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getName());
			pstm.setInt(2, user.getAge());
			pstm.setString(3, user.getPhoneNumber());
			pstm.setString(4, encrypt(user.getPw()));
			pstm.setInt(5, userNumber);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateInfo() SQL 오류");
			
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//회원 번호로 회원 정보 검색
	public UserVO selectUser() {
		String query = "SELECT * FROM TBL_USER WHERE USERNUMBER = ?";
		UserVO user = new UserVO();
		int idx = 1;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, userNumber);
			rs = pstm.executeQuery();
			
			rs.next();
			
			user.setUserNumber(rs.getInt(idx++));
			user.setId(rs.getString(idx++));
			user.setPw(rs.getString(idx++));
			user.setName(rs.getString(idx++));
			user.setAge(rs.getInt(idx++));
			user.setPhoneNumber(rs.getString(idx++));
			user.setStatus(rs.getInt(idx++));
			
		} catch (SQLException e) {
			System.out.println("selectUser() SQL 오류");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return user;
	}
	
	
	
	//회원 탈퇴
	//로그인 된 회원만 회원탈퇴 가능, 탈퇴 시 비밀번호 한 번 더 입력
	public boolean delete(String pw) {
		UserVO user = selectUser();
		String query = null;
		boolean check = false;
		
		if(user.getPw().equals(encrypt(pw))) {
			query = "UPDATE TBL_USER SET STATUS = 1 WHERE USERNUMBER = ?";
			try {
				conn = DBConnecter.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setInt(1, user.getUserNumber());
				check = pstm.executeUpdate() == 1;
				
			} catch (SQLException e) {
				System.out.println("delete() SQL 오류");
			} finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return check;
	}
	
	//회원 탈퇴 복구
	public void restore() {
		String query = "UPDATE TBL_USER SET STATUS = 0 WHERE USERNUMBER = ?";
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, userNumber);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete() SQL 오류");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void restore(String id, String pw) {
		if(login(id, pw) == -1) {return;}
		
		UserVO user = selectUser();
		
		if(user.getStatus() == 0) {return;}
		
		String query = "UPDATE TBL_USER SET STATUS = 0 WHERE USERNUMBER = ?";
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, userNumber);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete() SQL 오류");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//핸드폰 중복검사
	public boolean checkPhoneNumber(String phoneNumber) {
		String query = "SELECT COUNT(*) FROM TBL_USER WHERE phoneNumber = ?";
		boolean check = false;
		try {
			//연결 객체 전달받기
			conn = DBConnecter.getConnection();
			
			//작성한 SQL문을 prepareStatement에 전달
			pstm = conn.prepareStatement(query);
			
			//?에 들어갈 값을 전달하여 SQL문 완성
			pstm.setString(1, phoneNumber);
			
			//완성된 SQL문 실행, 결과를 ResultSet객체에 담기
			rs = pstm.executeQuery();
			
			//행 가져오기
			rs.next();
			//첫번째 열 가져오기
			check = rs.getInt(1) == 1;
			
		} catch (SQLException e) {
			System.out.println("checkId() SQL 오류");
			
		} finally {
			//열었던 객체들을 모두 닫아준다.
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				//닫을 때 문제 발생 시 예외 발생 후 강제종료해준다.
				throw new RuntimeException(e.getMessage());
			}
		}
		//아이디 중복검사 결과를 리턴한다(true : 중복있음, false : 중복없음)
		return check;
	}
	
	//회원가입 시 동일한 핸드폰 번호로 3번만 가입 가능하다.
	//탈퇴된 계정은 개수에서 제외한다.
	//예) 일반계정 2개, 탈퇴 계정 1개 -> 회원가입 가능
	//     일반계정 3개, 탈퇴 계정 1개 -> 회원가입 불가능
	public boolean checkJoin(String phoneNumber) {
		//사용자가 입력한 휴대폰 번호를 조회해서 동일한 번호이면서, 일반 계정인 회원의 개수를 센다.
		String query = "SELECT COUNT(*) FROM TBL_USER WHERE PHONENUMBER = ? AND STATUS = 0";
		boolean check = false;
		
		conn = DBConnecter.getConnection();
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phoneNumber);
			rs = pstm.executeQuery();
			
			//if문에 안들어가면 핸드폰번호가 중복되지 않는다는 뜻
			if(rs.next()) {//결과가 1개라도 있다면
				check = rs.getInt(1) == 3; //결과값이 3이라면 check에 true 대입
			}
			
		} catch (SQLException e) {
			System.out.println("checkJoin() SQL 오류");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				//닫을 때 문제 발생 시 예외 발생 후 강제종료해준다.
				throw new RuntimeException(e.getMessage());
			}
		}
		return !check; //회원가입 가능 true, 회원가입 불가능 false
	}
	
	//회원탈퇴 복구 수정
	//예) 일반계정 3개, 탈퇴 계정 3개 -> 복구 불가능
	//복구를 원할 때에는 일반 계정 중 탈퇴할 계정을 선택하여 탈퇴 후 복구
	
	//만약 restore()에서 바로 검사를 하면, 복구를 따로 하겠다는 의미이고
	//메소드를 새로 추가해서 검사를 하면, 복구를 한 번에 하겠다는 의미이다.
}


















