package myApi;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

//ctrl + shift + o : 자동 임포트
public class SMS {
	public static void main(String[] args) {
		String api_key = "API KEY";
	    String api_secret = "API SECRET KEY";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", "01000000000");
	    params.put("from", "01000000000");
	    params.put("type", "SMS");
	    params.put("text", "오늘도 화이팅!");
	    params.put("app_version", "test app 2.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
}
