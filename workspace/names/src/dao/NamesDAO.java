package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import vo.ManVO;
import vo.NamesDTO;
import vo.WomanVO;

public class NamesDAO {
	
	//남자 아이의 전체 정보를 담을 ArrayList
	public ArrayList<ManVO> men;
	
	//여자 아이의 전체 정보를 담을 ArrayList
	public ArrayList<WomanVO> women;
	
	//병합
	//외부에서 경로 3개를 전달받는다.
	//path1 : 기존 파일 경로 1
	//path2 : 기존 파일 경로 2
	//path3 : 병합된 내용을 출력할 경로
	public void merge(String path1, String path2, String path3) throws IOException{
		BufferedReader manReader = DBConnecter.getReader(path1);
		BufferedReader womanReader = DBConnecter.getReader(path2);
		
		ManDAO mDao = new ManDAO();
		WomanDAO wDao = new WomanDAO();
		
		String line = null;
		
		//남자아이와 여자아이의 전체 정보를 문자열로 저장할 변수
		String temp = "";
		
		men = new ArrayList<>();
		women = new ArrayList<>();
		
		while((line = manReader.readLine()) != null) {
			temp += line + "\n";
			//남자 정보는 men에 저장
			men.add(mDao.setObject(line));
		}
		manReader.close();
		
		while((line = womanReader.readLine()) != null) {
			temp += line + "\n";
			//여자 정보는 women에 저장
			women.add(wDao.setObject(line));
		}
		womanReader.close();
		
		BufferedWriter bw = DBConnecter.getWriter(path3);
		//path3에 남자아이와 여자아이의 전체 정보를 출력한다.
		bw.write(temp);
		bw.close();
	}
	
	//랭킹 수정
	//병합된 파일의 경로를 전달받는다.
	public void update(String path) throws IOException {
		//남자 아이와 여자아의 전체 정보를 저장할 ArrayList
		ArrayList<Object> datas = new ArrayList<>();
		//아이 이름별 인구 수를 저장할 ArrayList
		ArrayList<Integer> populations = new ArrayList<>();
		//중복되는 인구 수를 없애기 위한 HashSet
		HashSet<Integer> populationSet = null;
		
		//datas에 men과 women의 전체 내용을 합쳐준다.
		datas.addAll(men);
		datas.addAll(women);

		//아이 이름별 인구 수를 populations에 담아준다.
		men.stream().map(v -> v.getPopulation()).forEach(populations::add);
		women.stream().map(v -> v.getPopulation()).forEach(populations::add);
		
		//중복을 제거한다.
		populationSet = new HashSet<>(populations);
		
		//다시 ArrayList에 담아준다.
		populations = new ArrayList<>(populationSet);
		
		//내림 차순 정렬을 해준다.
		Collections.sort(populations);
		Collections.reverse(populations);
		
		//순위는 1위부터 시작한다.
		int ranking = 1;
		//내림차순 된 아이들의 정보를 문자열로 담아줄 변수
		String result = "";
		
		//내림 차순으로 정렬된 인구 수를 기준으로 반복을 진행한다.
		for (Integer population : populations) {
			//공동 순위의 개수를 세어 준다.
			int count = 0;
			for (Object vo : datas) {//각 아이들의 정보만큼 반복한다.
				if(vo instanceof ManVO) {//만약 남자 아이라면
					ManVO data = (ManVO)vo;//다운 캐스팅 진행
					if(data.getPopulation() == population) {//아이의 인구 수와 내림차순된 인구 수를 비교한다.
						NamesDTO sortedDatas = new NamesDTO();//해당 인구 수의 아이 정보를 담아줄 객체
						sortedDatas.setName(data.getName());
						sortedDatas.setRanking(ranking);
						sortedDatas.setPopulation(population);
						sortedDatas.setGender('M');//성별 추가
						
						result += sortedDatas; //toString()재정의를 통해 알맞는 형식의 문자열을 result에 담아준다.
						count++; //공동 순위 개수 증가
						
					}
				}
				if(vo instanceof WomanVO) {
					WomanVO data = (WomanVO)vo;
					if(data.getPopulation() == population) {
						NamesDTO sortedDatas = new NamesDTO();
						sortedDatas.setName(data.getName());
						sortedDatas.setRanking(ranking);
						sortedDatas.setPopulation(population);
						sortedDatas.setGender('W');
						
						result += sortedDatas;
						count++;
					}
				}
			}
			//만약 같은 순위의 개수가 1보다 크다면 다음 순위에 그 만큼을 더해준다.
			if(count > 1) {ranking += count - 1;}
			ranking++;
		}
		
		BufferedWriter bw = DBConnecter.getWriter(path);
		bw.write(result);
		bw.close();
	}
}













