package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CGV {
	private WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	
	public static void main(String[] args) {
		CGV cgv = new CGV();
		String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		
		//운영체제에 드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//ChromeDriver를 driver에 담아주기
		cgv.driver = new ChromeDriver();
		cgv.driver.get(url);
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		//더보기 버튼 가져와서 클릭해주기
		cgv.driver.findElement(By.className("btn-more-fontbold")).click();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		int ranking = 0;

		// 사용자가 선택한 영화의 예매하기 버튼을 클릭한 뒤
		// 상영되고 있는 극장의 전체 개수를 출력한다.
		Scanner sc = new Scanner(System.in);
		int index = 0;
		
		//예매하기 버튼들
		List<WebElement> btns = cgv.driver.findElements(By.cssSelector("a.link-reservation"));
		
		//영화 제목들
		List<WebElement> titles = cgv.driver.findElements(By.cssSelector("a strong.title"));
		
		for (WebElement film : titles) {
			//1부터 시작하는 번호와 함께 영화 제목을 출력한다.
			System.out.println(++ranking + ". " + film.getText());
		}
		
		System.out.println("예매하고자 하는 영화 번호를 입력하세요.");
		try {
			//예매하고자 하는 영화의 번호를 입력한다.
			index = sc.nextInt();
			
			// a태그의 href값을 getAttribute를 통해 가져온 뒤
			// get메소드에 전달하여 브라우저의 url을 직접 변경시킨다.
			// **getAttribute("속성명") == 속성값
			cgv.driver.get(btns.get(index - 1).getAttribute("href"));
			
			try {Thread.sleep(1000);} catch (Exception e) {;}
			
			//극장의 총 개수
			int total = 0;
			
			//예매하기 페이지에서 iframe을 사용했기 때문에 해당 URL로 다시 이동해주어야 한다.
			//iframe : 브라우저 안에 브라우저를 추가하는 것!
			cgv.driver.get(cgv.driver.findElement(By.id("ticket_iframe")).getAttribute("src"));
			
			try {Thread.sleep(1000);} catch (Exception e) {;}
			
			for(WebElement count : cgv.driver.findElements(By.cssSelector("span.count"))) {
				//"(극장수)"를 result에 담아준다.
				String result = count.getText();
				try {
					//"(극장수)" 를  "극장수"로 변경시킨 후 정수로 변환한다.
					//substring('(' 다음 인덱스부터, ')' 전까지) : 괄호를 제외한 극장 수만 추출
					total += Integer.parseInt(result.substring(result.indexOf("(") + 1, result.indexOf(")")));
				} catch (Exception e) {
					//만약 극장 수가 비워져있다면 일반 제어문으로 처리할 수 없기 때문에
					//예외처리 후 다음 반복으로 넘어가준다.
					continue;
				}
			}
			System.out.println("총 극장 수 : " + total + "개");
			// [실습]
			// 사용자가 선택한 영화의 예매하기 페이지에서 상영되고 있는 
			// 극장 수를 가져온 뒤 총 합을 출력한다.
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("오류" + e);
		}
		
//		cgv.driver.findElements(By.cssSelector("a strong.title")).forEach(film -> System.out.println(film.getText()));
//		System.out.println(cgv.driver.findElement(By.cssSelector("a strong.title")).getText());
		
		//크롬 종료
		cgv.driver.close();
		cgv.driver.quit();
	}
	
}












