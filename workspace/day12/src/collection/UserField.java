package collection;

import java.util.ArrayList;
import java.util.HashMap;

public class UserField {
	//회원을 저장할 자료구조 선언
	ArrayList<User> users = new ArrayList<>();
	
	//암호키
	private static final int KEY = 3;
	
	//아이디 중복검사
	//boolean보다 User타입으로 리턴하는 것이 좋다.
	public User checkId(String id) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId().equals(id)) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}
	//회원가입
	public void join(User user) {
		user.setPw(encrypt(user.getPw()));
		users.add(user);
	}
	
	//로그인(아이디랑 비밀번호를 받아서 암호화된 비밀번호끼리 비교)
	public boolean login(String id, String pw) {
		User user = checkId(id);
		if(user != null) {
			if(user.getPw().equals(encrypt(pw))) {
				return true;
			}
		}
		return false;
	}
	
	//암호화(단방향)
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * 3);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / 3);
		}
		return de_pw;
	}
	
	//비밀번호 찾기(이름과 핸드폰 번호로 찾기, SMS로 비밀번호 전송)
	public boolean findPw(String name, String phoneNumber) {
		for (int i = 0; i < users.size(); i++) {
			boolean checkName = users.get(i).getName().equals(name);
			boolean checkPhoneNumber = users.get(i).getPhone().equals(phoneNumber);
			
			if(checkName && checkPhoneNumber) {
				//문자 발송
//				sendSMS(phoneNumber, decrypt(users.get(i).getPw()));
				return true;
			}
		}
		return false;
	}
	
	//SMS
//	public void sendSMS(String phoneNumber, String pw) {
//		String api_key = "API KEY";
//	    String api_secret = "API SECRET KEY";
//	    Message coolsms = new Message(api_key, api_secret);
//
//	    // 4 params(to, from, type, text) are mandatory. must be filled
//	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", phoneNumber);
//	    params.put("from", "01000000000");
//	    params.put("type", "SMS");
//	    params.put("text", pw);
//	    params.put("app_version", "test app 2.2"); // application name and version
//
//	    try {
//	      JSONObject obj = (JSONObject) coolsms.send(params);
//	      System.out.println(obj.toString());
//	    } catch (CoolsmsException e) {
//	      System.out.println(e.getMessage());
//	      System.out.println(e.getCode());
//	    }
//	}
	
}









