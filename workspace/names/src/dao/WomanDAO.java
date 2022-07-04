package dao;

import vo.WomanVO;

public class WomanDAO {
	public WomanVO setObject(String data) {
		String[] datas = data.split("\t");
		WomanVO woman = new WomanVO();
		
		woman.setName(datas[0]);
		woman.setRanking(Integer.parseInt(datas[1]));
		woman.setPopulation(Integer.parseInt(removeComma(datas[2])));
		
		return woman;
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
}
