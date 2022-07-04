package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Melon {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	
	public Melon() {
		//드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//브라우저 옵션
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		url = "https://www.melon.com/";
		driver.get(url);
	}
	
	public void operate() {
		searchSong();
		driver.close();
		driver.quit();
	}
	
	public void searchSong() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가수/곡명 : ");
		
		//상단 검색창 input태그
		WebElement input = driver.findElement(By.id("top_search"));
		
		//사용자가 입력한 키워드를 해당 input태그에 입력한다.
		input.sendKeys(sc.nextLine());
		
		try {Thread.sleep(500);} catch (InterruptedException e) {;}
		
		//엔터 전송
		input.sendKeys(Keys.RETURN);
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		List<WebElement> btns = driver.findElements(By.cssSelector("form#frm_searchSong a.btn_icon_detail"));
		List<WebElement> titles = driver.findElements(By.cssSelector("form#frm_searchSong a.fc_gray"));
		//선택자1:not(선택자2) : 선택자1안에 선택자2를 제외한 나머지
		List<WebElement> artists = driver.findElements(By.cssSelector("form#frm_searchSong div#artistName:not(span)"));
		int count = 0;
		int index = 0;
		
		for(int i=0; i< titles.size(); i++) {
			System.out.println(++count + ". " + titles.get(i).getAttribute("title") + ", " + artists.get(i).getText());
		}
		System.out.println("가사를 열람할 곡의 번호를 입력하세요.");
		index = sc.nextInt();
		
		
		btns.get(index - 1).click();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
//		driver.findElement(By.id("lyricArea")).findElement(By.className("button_more")).click();
//		try {Thread.sleep(500);} catch (InterruptedException e) {;}
		
		
		try {
			driver.findElement(By.className("adult_register"));
			System.out.println("성인 인증이 필요한 가사입니다.");
		} catch (Exception e) {
			try {
				driver.findElement(By.className("d_register"));
				System.out.println("가사가 없는 곡입니다.");
			} catch (Exception e1) {
				System.out.println(driver.findElement(By.id("d_video_summary")).getText());
			}
		}
	}
	
	public static void main(String[] args) {
		Melon m = new Melon();
		m.operate();
	}
	
}


















