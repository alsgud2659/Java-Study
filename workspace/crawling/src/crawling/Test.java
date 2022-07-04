package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test implements Runnable{
   private WebDriver driver;
   public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
   public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
   
   public static void main(String[] args) {
      Test cgv = new Test();
      String url = "https://kr.trip.com/travel-restrictions-covid-19/";
      
      //운영체제에 드라이버 설정
      System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
      
      //ChromeDriver를 driver에 담아주기
      cgv.driver = new ChromeDriver();
      cgv.driver.get(url);
      
      //팝업 감지 쓰레드 실행
      new Thread(cgv).start();
      try {Thread.sleep(1000);} catch (InterruptedException e) {;}
      
      //사용자가 검색하고자 하는 나라 입력
      cgv.driver.findElement(By.cssSelector("div.to-box div.search-content input.inputsearch-input")).sendKeys("스웨덴");
      try {Thread.sleep(1000);} catch (InterruptedException e) {;}

      //입력된 나라에 대한 페이지로 이동
      cgv.driver.findElement(By.cssSelector("div.datalist-content ul:first-child")).click();
      try {Thread.sleep(1000);} catch (InterruptedException e) {;}
      
//      System.out.println(cgv.driver.findElement(By.cssSelector("div.policy-content")).getText());
//      System.out.println(cgv.driver.findElement(By.cssSelector("div.policy-content")).findElement(By.tagName("a")).getAttribute("href"));
      for (WebElement text : cgv.driver.findElements(By.cssSelector("div.policy-type-content:last-child div.policy-text div div"))){
    	  System.out.println(text.getText());
      }
    		  
      
      //크롬 종료
      cgv.driver.close();
      cgv.driver.quit();
   }
   @Override
   public void run() {
         while(true) {
            try {
               //팝업창 가져옴
               WebElement div = driver.findElement(By.cssSelector("div.sc-1e79edz-0"));
               //위에서 오류 발생 시 팝업이 없다는 얘기, 팝업이 뜨면 여기 밑으로 내려옴
               
               //javascript 써야해서 객체 준비
               JavascriptExecutor js = (JavascriptExecutor) driver;
               //팝업이 떳다면 해당 태그의 display를 none으로 변경
               js.executeScript("arguments[0].style.display='none';", div);
               //1초마다 팝업창 떳는 지 검사
               try {Thread.sleep(1000);} catch (Exception e) {;}
            } catch (Exception e) {}
         }
   }
   
}











