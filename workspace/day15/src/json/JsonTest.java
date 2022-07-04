package json;

import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// JSON : 데이터 교환 방식
// "{" 로 시작해서 "}"로 마친다.
public class JsonTest {
	public static void main(String[] args) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap.put("id", "hds1234");
		userMap.put("pw", "1234");
		userMap.put("name", "한동석");
		
		JSONObject jsonObj = new JSONObject(userMap);
		System.out.println(jsonObj.toJSONString());
		
		jsonObj.put("age", 10);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj2 = new JSONObject(userMap);
		jsonObj2.put("id", "hds5555");
		jsonObj2.put("pw", "5555");
		jsonObj2.put("name", "홍길동");
		jsonObj2.put("age", 20);
		
		jsonArr.add(jsonObj);
		jsonArr.add(jsonObj2);
		
		System.out.println(jsonArr.toJSONString());
		
		JSONObject jsons = new JSONObject();
		jsons.put("개발", jsonObj);
		jsons.put("보안", jsonObj2);
		
		System.out.println(jsons.toJSONString());
		
		System.out.println(((JSONObject)jsonArr.get(1)).get("name"));		
		System.out.println(((JSONObject)jsonArr.get(0)).get("id"));		
		
		//위에 선언한 jsons를 사용하여 개발팀의 전체 정보를 출력한다.
		JSONObject developer = (JSONObject)jsons.get("개발");
		Iterator<Object> iter = developer.keySet().iterator();
		while(iter.hasNext()) {
			System.out.println(developer.get(iter.next()));
		}
	}
}










