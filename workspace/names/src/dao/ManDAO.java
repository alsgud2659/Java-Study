package dao;

import vo.ManVO;

public class ManDAO {
	//파일에 있는 내용 중 한 줄을 전달받는다.
	public ManVO setObject(String data) {
		//전달받은 문자열을 \t로 구분하여 잘라준다.
		String[] datas = data.split("\t");
		ManVO man = new ManVO();
		
		//각 정보를 모델 객체에 담아준다.
		man.setName(datas[0]);
		man.setRanking(Integer.parseInt(datas[1]));
		//쉼표는 정수로 바꿀 수 없기 때문에 쉼표를 없애준다.
		man.setPopulation(Integer.parseInt(removeComma(datas[2])));
		
		return man;
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
}
