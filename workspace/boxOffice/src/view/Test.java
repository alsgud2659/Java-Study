package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import dao.BoxOfficeDAO;
import vo.BoxOfficeVO;

public class Test {
	public static void main(String[] args) throws IOException{
		BoxOfficeVO film = new BoxOfficeVO();
		BoxOfficeDAO dao = new BoxOfficeDAO();
//		ArrayList<BoxOfficeVO> films = new ArrayList<>();
		
		//검색
//		dao.selectFilm("아").forEach(System.out::println);
		
		//목록
//		dao.selectAll().forEach(System.out::println);
		
		//추가, 삽입
//		film.setRanking(501);
//		film.setName("자바좋아");
//		dao.appendAndInsert(film);
//		dao.append(film);
//		dao.insert(film);
		
		//삭제
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("삭제하실 영화 제목 : ");
//		films = dao.selectFilm(sc.next());
//		
//		if(films.size() > 1) {
//			System.out.println("삭제하실 영화의 번호를 입력하세요.");
//			films.forEach(System.out::println);
//			dao.remove(sc.nextInt());
//			
//		}else if(films.size() == 1) {
//			dao.remove(films.get(0).getRanking());
//			
//		}else {
//			System.out.println("그런 영화는 없습니다.");
//		}	
		
		
		//수정
//		int choice = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("수정하실 영화 제목 : ");
//		films = dao.selectFilm(sc.next());
//		
//		if(films.size() > 1) {
//			System.out.println("수정하실 영화의 번호를 입력하세요.");
//			films.forEach(System.out::println);
//			
//			film.setRanking(sc.nextInt());
//
//			for(BoxOfficeVO vo : films) {
//				if(vo.equals(film)) {
//					film = vo;
//				}
//			}
//			
//			System.out.println("수정하실 항목을 선택하세요.");
//			System.out.println("1. 영화제목\n2. 개봉일\n3. 수익\n4. 관객 수\n5. 상영횟수");
//			choice = sc.nextInt();
//			
//			System.out.print("새로운 정보 입력 : ");
//			switch(choice) {
//			case 1:
//				film.setName(sc.next());
//				break;
//			case 2:
//				film.setReleaseDate(sc.next());
//				break;
//			case 3:
//				film.setIncome(sc.nextLong());
//				break;
//			case 4:
//				film.setAudience(sc.nextInt());
//				break;
//			case 5:
//				film.setScreenCount(sc.nextInt());
//				break;
//			}
//			
//			dao.update(film);
//			
//		}else if(films.size() == 1) {
//			
//			film.setRanking(films.get(0).getRanking());
//			
//			System.out.println("수정하실 항목을 선택하세요.");
//			System.out.println("1. 영화제목\n2. 개봉일\n3. 수익\n4. 관객 수\n5. 상영횟수");
//			choice = sc.nextInt();
//			
//			System.out.print("새로운 정보 입력 : ");
//			switch(choice) {
//			case 1:
//				film.setName(sc.next());
//				break;
//			case 2:
//				film.setReleaseDate(sc.next());
//				break;
//			case 3:
//				film.setIncome(sc.nextLong());
//				break;
//			case 4:
//				film.setAudience(sc.nextInt());
//				break;
//			case 5:
//				film.setScreenCount(sc.nextInt());
//				break;
//			}
//		}else {
//			System.out.println("그런 영화는 없습니다.");
//		}
	}
}














