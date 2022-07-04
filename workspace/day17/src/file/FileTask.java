package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException{
		//food.txt파일을 현재 경로에 생성하고,
		//파일 내용은 족발, 보쌈, 짜장면, 탕수육 네 가지 음식으로 작성한다(append : true)
		//각 음식은 줄바꿈 후 다음 음식을 넣도록 한다.
//		BufferedWriter bw = new BufferedWriter(new FileWriter("food.txt", true));
//		String[] foods = {"짜장면", "탕수육"};
//		
//		for (int i = 0; i < foods.length; i++) {
//			bw.write(foods[i] + "\n");
//		}
//		
//		bw.close();

		//작성한 내용을 콘솔에 출력한다.
//		BufferedReader br = null;
//		String line = null;
//		try {
//			br = new BufferedReader(new FileReader("food.txt"));
//			
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			System.out.println("파일이 없습니다.");
//		} finally {
//			if(br != null) {
//				br.close();
//			}
//		}
		
//		File f = new File("food.txt");
//		if(f.exists()) {
//			f.delete();
//			System.out.println("삭제 성공");
//		}
	}
}










