package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.BoxOfficeVO;

public class BoxOfficeDAO {
	
	//추가와 삽입
	//사용자가 여러 개의 메소드를 골라서 사용하면 혼란스럽기 때문에
	//기존의 append()와 insert()를 하나로 합쳐서
	//appendAndInsert()를 사용하도록 구현한다.
	public void appendAndInsert(BoxOfficeVO film) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		int lastRanking = 0;
		
		//마지막 순위 구하기
		while(br.readLine() != null) {lastRanking++;}
		
		//사용자가 만약 랭킹을 전달했다면 삽입, 랭킹을 전달하지 않는다면 추가
		//하지만 마지막 순위 + 1에 삽입을 시도하면 추가로 전환해준다.
		if(film.getRanking() != 0 && lastRanking + 1 != film.getRanking()) {
			insert(film);
			return;
		}
		append(film);
	}
	
	//추가
	//외부에서 새로운 영화 정보를 전달받는다.
	private void append(BoxOfficeVO film) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		
		//전체 내용을 문자열로 담기 위한 저장공간
		String content = null;
		
		//줄바꿈 문자 및 추가될 내용을 저장할 저장공간
		String data = "";
		
		//마지막 순위
		int lastRanking = 0;
		
		while(br.readLine() != null) {
			//총 반복 횟수가 마지막 순위이다.
			lastRanking++;
		}
		br.close();
		
		//해당 경로의 파일 내용을 모두 바이트로 가져온 후
		//String 생성자에 전달하면 문자열로 변환된다.
		//readLine()을 사용해서 내용을 가져오면 \n을 가져올 수 없기 때문에 readAllBytes()를 사용한다.
		content = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath())));
		
		//만약 전체 내용 중 마지막 문자가 줄바꿈 문자가 아니라면 \n을 넣어준다.
		data = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
		//새로운 영화의 전체 정보에서 순위를 제외한 나머지 정보를 substring을 사용하여 분리한다.
		//1번정보\t2번정보\t....
		//첫번째 \t부터 끝까지 : film.toString().substring(film.toString().indexOf("\t"))
		//마지막에 영화 정보가 추가되기 때문에 마지막 순위 + 1을 해준다.
		data += lastRanking + 1 +  film.toString().substring(film.toString().indexOf("\t"));
				
		BufferedWriter bw = DBConnecter.getAppend();
		//새로운 영화 정보를 마지막 줄에 추가한다.
		bw.write(data);
		bw.close();
	}
	
	//삽입
	//새로운 영화 정보를 매개변수로 전달받는다.
	private void insert(BoxOfficeVO film) throws IOException{
		//순위 검사
		//기존 영화 정보를 temp에 담으면서 반복 진행
		//만약 삽입할 순위를 찾았다면 그 자리에 새로운 영화 정보를 담아준다.
		//삽입 후에는 기존 영화의 순위들이 +1 되어야 한다.
		//결과를 기존 파일에 덮어써야 한다.
		
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		
		//기존 내용 + 삽입할 내용 정보를 담아줄 변수
		String temp = "";
		
		//삽입할 순위를 newRanking에 담아준다.
		int newRanking = film.getRanking();
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			//영화의 순위를 비교하여 삽입할 라인을 찾는다.
			if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				//삽입할 라인을 찾았다면 해당 순위에 새로운 정보를 삽입해준다.
				temp += film.toString() + "\n";
				//아래에서 삽입 유무를 확인해야 하기 때문에 FLAG를 사용하여 체크한다.
				//FLAG : 해당 영역에서 모든 기능을 구현할 수 없을 때 표시를 하기 위한 기법
				//깃발을 흔드는 게 아니라 꽂고(표시하고) 빠져나온다는 뜻
				check = true;
			}
			//위에서 삽입이 되었는 지를 검사
			//만약 위에서 삽입이 되었다면 기존 순위의 영화부터 마지막 순위의 영화까지
			//랭킹이 1씩 더 증가해야 한다.
			temp += check ?  ++newRanking + line.substring(line.indexOf("\t")) : line;
			temp += "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		//삽입 된 정보로 기존 정보를 덮어씌운다.
		bw.write(temp);
		bw.close();
	}
	
	//수정(영화 제목은 중복이 없다고 가정)
	//전달받은 영화정보 중 순위를 검색하여 일치하는 순위일 경우 새로운 영화의 정보로 수정한다.
	//외부에서 수정된 영화의 전체 정보를 받는다.
	public void update(BoxOfficeVO film) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		//기존 정보에서 수정 완료된 정보를 담을 변수
		String temp = "";
		
		while((line = br.readLine()) != null) {
			//사용자가 수정하고자 하는 영화의 순위를 비교한다.
			if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				//수정할 영화를 찾았다면 기존의 정보를 새로운 정보로 temp에 넣어준다.
				temp += film.toString() + "\n";
				//기존 정보 대신 넣은 것이기 때문에 아래의 기존정보를 담는 코드를 실행하지 않기 위해서 continue를 사용한다.
				continue;
			}
			//위에서 수정되지 않은 정보라면 그대로 temp에 담아준다.
			temp += line + "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		//수정완료된 정보로 덮어씌우기
		bw.write(temp);
		bw.close();
	}
	
	//삭제
	//삭제할 영화의 순위를 전달받는다.
	public void remove(int ranking) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		
		//삭제가 완료된 정보를 담을 변수
		String temp = "";
		
		//삭제할 영화의 순위를 담아준다.
		int newRanking = ranking;
		
		//FLAG
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			//삭제할 영화의 순위를 검색한다.
			if(Integer.parseInt(line.split("\t")[0]) == ranking) {
				//삭제 완료 표시
				check = true;
				
				//만약 삭제할 영화를 찾았다면 기존 정보를 temp에 넣지 않고 다음 줄로 넘어간다.
				continue;
			}
			//위에서 삭제가 되었다면 기존 정보부터 마지막 정보까지 순위를 하나씩 댕겨준다(-1).
			//후위형은 다음 줄부터 +가 되기 때문에 순위가 하나씩 당겨진다.
			temp += check ?  newRanking++ + line.substring(line.indexOf("\t")) : line;
			temp += "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		//삭제 완료된 전체 내용으로 덮어쓰기
		bw.write(temp);
		bw.close();
	}
	
	//검색
	//영화 제목으로 조회.
	//사용자가 입력한 키워드가 제목에 포함되어 있어도 결과에 담아준다.
	// "아" 검색 시 "아바타"도 검색 결과에 포함
	
	//외부에서 사용자가 검색하고자 하는 키워드를 전달받는다.
	//검색 결과가 한 개가 아니라 여러 개이므로 ArrayList에 담아서 리턴한다.
	public ArrayList<BoxOfficeVO> selectFilm(String keyword) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		ArrayList<BoxOfficeVO> films = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			//각각의 정보를 split()을 사용하여 분리한다.
			String[] filmDatas = line.split("\t");
			
			//영화제목에 사용자가 입력한 키워드가 포함되면
			if(filmDatas[1].contains(keyword)) {
				
				//모든 정보를 film객체에 담아준다.
				BoxOfficeVO film = new BoxOfficeVO();
				film.setRanking(Integer.parseInt(filmDatas[0]));
				film.setName(filmDatas[1]);
				film.setReleaseDate(filmDatas[2]);
				//만약 데이터가 비어있다면 0으로 대체한다.
				film.setIncome(Long.parseLong(removeComma(filmDatas[3].equals("") ? "0" : filmDatas[3])));
				film.setAudience(Integer.parseInt(removeComma(filmDatas[4])));
				film.setScreenCount(Integer.parseInt(removeS(removeComma(filmDatas[5]))));
				
				//모든 정보가 담긴 film객체를 ArrayList에 추가해준다.
				films.add(film);
			}
		}
		//검색 결과를 리턴한다.
		return films;
	}
	
	//쉼표 제거
	//전달받은 문자열에 ","가 있으면 없애준다.
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
	
	//S 제거
	//전달받은 문자열에 "S "가 있으면 없애준다.
	public String removeS(String data) {
		return data.replaceAll("S ", "");
	}
	
	//목록
	//전체 정보 리턴
	public ArrayList<BoxOfficeVO> selectAll() throws IOException{
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		ArrayList<BoxOfficeVO> films = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			String[] filmDatas = line.split("\t");
			BoxOfficeVO film = new BoxOfficeVO();
			film.setRanking(Integer.parseInt(filmDatas[0]));
			film.setName(filmDatas[1]);
			film.setReleaseDate(filmDatas[2]);
			film.setIncome(Long.parseLong(removeComma(filmDatas[3].equals("") ? "0" : filmDatas[3])));
			film.setAudience(Integer.parseInt(removeS(removeComma(filmDatas[4]))));
			film.setScreenCount(Integer.parseInt(removeS(removeComma(filmDatas[5]))));
			
			films.add(film);
		}
		return films;
	}
}






















